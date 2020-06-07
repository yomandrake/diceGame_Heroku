////Global Variables
var largeCanvas = true;
var numPlay = 0;



var num1, num2, num3, num4, num5, num6;
var diceFacesNum = [1, 2, 3, 4, 5, 6];
var logoDice;
var diceShow;
var diceFacesIMG = [];

var diceSize;
var gridSize;

var randomDices = [0, 0, 0, 0];
var dicesPlayed = [0, 0, 0, 0];
var lastRollJson;
var isWin;

//Initiate Game 
var gotResponse = true;
var isMinRollTime = true;

/**P5 canvas */
function preload() {
  logoDice = loadImage("data/logo.svg");
  num1 = loadImage("data/1.svg");
  num2 = loadImage("data/2.svg");
  num3 = loadImage("data/3.svg");
  num4 = loadImage("data/4.svg");
  num5 = loadImage("data/5.svg");
  num6 = loadImage("data/6.svg");
  diceFacesIMG = [logoDice, num1, num2, num3, num4, num5, num6];
}



function setup() {

  if(windowWidth > 500){

    var diceCanvas = createCanvas(380, 380);
    gridSize = 95;
    diceSize = 150;
  }else{
    largeCanvas = false;
    var diceCanvas = createCanvas(240, 240);
    gridSize = 60;
    diceSize = 100;
  }

  
  diceCanvas.parent('diceCanvas');

  frameRate(60);
}

/**Trick for resizing on big screen  */
window.onresize = checkCanvasSize;
function checkCanvasSize(){
    if(windowWidth < 500 && largeCanvas){
      largeCanvas = false;
      gridSize = 60;
      diceSize = 100;
      resizeCanvas(240,240)

    }else if (windowWidth > 500 && !largeCanvas){
      largeCanvas = true;
      gridSize = 95;
      diceSize = 150;
      resizeCanvas(380,380)
    }
}



function draw() {
  background(128, 206, 214);
  imageMode(CENTER);

  if (IsRolling()) {
    drawRandomDices();
  } else {
    drawDices();
  }

}

///Draw dices when response received
function drawDices() {
  //Draw Dices
  image(diceFacesIMG[dicesPlayed[0]], gridSize * 1, gridSize * 1, diceSize, diceSize);
  image(diceFacesIMG[dicesPlayed[1]], gridSize * 1, gridSize * 3, diceSize, diceSize);
  image(diceFacesIMG[dicesPlayed[2]], gridSize * 3, gridSize * 1, diceSize, diceSize);
  image(diceFacesIMG[dicesPlayed[3]], gridSize * 3, gridSize * 3, diceSize, diceSize);
}

///Draw dices when rolling
function drawRandomDices() {
  //Change dices values every 10 frames
  if (frameCount % 10 == 0) {
    randomDices = [
      random(diceFacesNum),
      random(diceFacesNum),
      random(diceFacesNum),
      random(diceFacesNum)
    ];
  }
  //Draw Dices
  image(diceFacesIMG[randomDices[0]], gridSize * 1, gridSize * 1, diceSize, diceSize);
  image(diceFacesIMG[randomDices[1]], gridSize * 1, gridSize * 3, diceSize, diceSize);
  image(diceFacesIMG[randomDices[2]], gridSize * 3, gridSize * 1, diceSize, diceSize);
  image(diceFacesIMG[randomDices[3]], gridSize * 3, gridSize * 3, diceSize, diceSize);
}



function rollButton() {
  //Minimun Roll of 3 seconds
  isMinRollTime = false;
  minRollTime();
  //Make the post call for a new game
  gotResponse = false;
  fetchNewGame()
    .catch(error => {
      console.log('error:');
      console.log(error);
    });
}


/**FETCH NEW GAME FOR A PLAYER BY ID */
///Async function to fetch a new game for player by player id
async function fetchNewGame() {
  const response = await fetch(`${this.localURL}players/` + playerLogged.playerId + '/games', {
    method: 'post'
  });
  if (response.status == 200) {
    const data = await response.json();
    lastRollJson = data;
    dicesPlayed = [data.dice1, data.dice2, data.dice3, data.dice4];
    isWin = data.isWin;
  }
  gotResponse = true;
}


/**MINIMUM ROLL TIME */
function startRoll(){
  document.getElementById('lastRollImg').classList.remove('animate__animated', 'animate__jackInTheBox');
}

function endRoll(){
  //Update Last Play
  console.log("End Roll");
  
  //Change Last Roll Message and image
  if(lastRollJson.isWin == 1){
    document.getElementById('lastRollImg').src = "data/tick.svg"
    document.getElementById('lastRollResult').innerHTML = " WIN !!!!"
  }else{
    document.getElementById('lastRollImg').src = "data/cross.svg"    
    document.getElementById('lastRollResult').innerHTML = " LOOSE.. Try Again!"
  }    
  //Update PlayerHistory
  getAllGamesForPlayer();
}

function animateResult(){  
  document.getElementById('lastRollImg').classList.add('animate__animated', 'animate__jackInTheBox');
}

///Async function to set a minimum rolling time of 3 seconds
async function minRollTime() {
  startRoll();
  const result = await resolveAfter3Seconds();
  isMinRollTime = true;
  endRoll();
  animateResult();
}
function resolveAfter3Seconds() {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve('3 second Roll - OK');
    }, 2500);
  });
}

///Decide if rolling 
function IsRolling() {
  if (gotResponse && isMinRollTime) { return false; }
  else { return true; }
}


