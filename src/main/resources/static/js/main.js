//Global Variables
var localURL = window.location.href;
var playerLogged;
var diceRanking = [];

class PlayerDTO {

  constructor(jsonPlayerDTO) {
    this.playerLogName = jsonPlayerDTO.playerLogName;
    this.playerId = jsonPlayerDTO.playerId;
    this.playerName = jsonPlayerDTO.playerName;
    this.playerRegDate = jsonPlayerDTO.playerRegDate;
    this.playerWinStats = jsonPlayerDTO.playerWinStats;
  }

}


function toggleDiceGame() {
  var x = document.getElementById("diceGame_boardgame");
  var y = document.getElementById("signInPage");

  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display = "none";
  } else {
    x.style.display = "none";
    y.style.display = "block";
  }
};

function startNewGame() {
  toggleDiceGame();
  document.getElementById('playerCanvasName').innerHTML = this.playerLogged.playerLogName;
  //Winner Name
  updateWinner("");
  getWinner()
    .catch(error => {
      console.log('error best player:');
      console.log(error);
    });
  //Ranking Table
  cleanRankingTable();
  getRanking()
    .catch(error => {
      console.log('error ranking table:');
      console.log(error);
    });
}


async function submitPlayerForm(e, form) {
  e.preventDefault();
  postNewPlayer(form.playerName.value, form.playerLogName.value)
    .catch(error => {
      console.log('error:');
      console.log(error);
    });
}

/* The fetch form can also be achieved by registering an event listener to form  or using  */
// document.forms['playerForm'].addEventListener('submit', (event) => {
//     event.preventDefault();

//     postNewPlayer('Emiliano','mandrake')
//         .catch(error => {
//             console.log('error:');
//             console.log(error);
//         });
// });

async function postNewPlayer(newPlayerName, newPlayerLogName) {
  //Post to BackEnd - Heroku App
  const response = await fetch(`${this.localURL}players`, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ playerName: newPlayerName, playerLogName: newPlayerLogName })
  });

  if (response.ok) {
    const data = await response.json();
    this.playerLogged = new PlayerDTO(data);
    startNewGame();

  } else if (response.status == 409) {
    const dataError = await response.json();
    swal("Sorry..@"+ newPlayerLogName +" already taken", "Try a different Nickname.. ", "error");
  }

}

/**
 * Best Player Section * 
 */
async function getWinner() {
  const response = await fetch(`${this.localURL}players/ranking/winner`, {
    method: 'GET'
  });
  if (response.status == 200) {
    const data = await response.json();   
    updateWinner(data.playerLogName);
  }
}

function updateWinner(playerLogName){
  var winnerName = document.getElementById("winnerLogName");
  winnerName.innerHTML = playerLogName;
}


/**
 * History Section
 */
function getAllGamesForPlayer(){
  fetchAllGamesForPlayer()
  .catch(error => {
    console.log('error games history:');
    console.log(error);
  });
}
async function fetchAllGamesForPlayer() {
  const response = await fetch(`${this.localURL}players/` + playerLogged.playerId + '/games', {
    method: 'GET'
  });
  if (response.status == 200) {
    const data = await response.json();
    updateHistoryTable(data);
  }
}
function updateHistoryTable(playerAllGames){
  cleanHistoryTable();
  var table = document.getElementById("playerHistoryTable");
  var historyLength = playerAllGames.length;

  for (let index = 0; index < historyLength; index++) {
    const element = playerAllGames[index];
    let row = table.insertRow(1);
    let cellPosition = row.insertCell(0);
    let cellDice1 = row.insertCell(1);
    let cellDice2 = row.insertCell(2);
    let cellDice3 = row.insertCell(3);
    let cellDice4 = row.insertCell(4);
    let cellIsWin = row.insertCell(5);
    cellPosition.innerHTML = (historyLength - index);

    cellDice1.innerHTML = element.dice1;
    cellDice2.innerHTML = element.dice2;
    cellDice3.innerHTML = element.dice3;
    cellDice4.innerHTML = element.dice4;    
    if(element.isWin == 1){
      cellIsWin.innerHTML = "WIN..!!";
    }else{
      cellIsWin.innerHTML = "LOOSE..";
    }
    
  }
}
function cleanHistoryTable(){
  var historyLenght = document.getElementById('playerHistoryTable').rows.length;
  for (let index = 0; index < historyLenght - 1; index++) {
    document.getElementById('playerHistoryTable').deleteRow(1);    
  }
}

function deleteAllGamesForPlayer(){
  cleanHistoryTable();
  fetchDeleteGamesForPlayer()
  .catch(error => {
    console.log('error deleting history:');
    console.log(error);
  });
}
async function fetchDeleteGamesForPlayer() {
  const response = await fetch(`${this.localURL}players/` + playerLogged.playerId + '/games', {
    method: 'DELETE'
  });
  if (response.status == 200) {
    const data = await response.json();
    updateHistoryTable("");
  }
}

/**
 * Ranking Section
 */ 
function updateRankingButton() {
  cleanRankingTable();
  getRanking()
    .catch(error => {
      console.log('error:');
      console.log(error);
    });
}
async function getRanking() {
  const response = await fetch(`${this.localURL}players/ranking`, {
    method: 'GET'
  });
  if (response.status == 200) {
    const data = await response.json();
    this.diceRanking = data;
    updateRankingTable(this.diceRanking);
  }
}

function updateRankingTable(rankingArray) {
  var table = document.getElementById("gameRankingTable");
  var rankingLength = rankingArray.length;
  for (let index = 0; index < rankingLength; index++) {
    const element = rankingArray[index];
    let row = table.insertRow(1);
    let cellPosition = row.insertCell(0);
    let cellName = row.insertCell(1);
    let cellQtPlays = row.insertCell(2);
    let cellAvgWin = row.insertCell(3);
    let cellProgresBar = row.insertCell(4);
    cellPosition.innerHTML = (rankingLength - index);
    cellName.innerHTML = element.playerLogName;
    cellQtPlays.innerHTML = element.qtGames;
    cellAvgWin.innerHTML = `${Math.round(element.playerWinStats * 100)}%`;    
    cellProgresBar.innerHTML = '<div class="progress"><div class="progress-bar progress-bar-striped bg-warning" role="progressbar" style="width:'+`${Math.round(element.playerWinStats * 100)}%`+'" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div></div>';
  }
}

function cleanRankingTable(){
  var rankignLenght = document.getElementById('gameRankingTable').rows.length;
  for (let index = 0; index < rankignLenght - 1; index++) {
    document.getElementById('gameRankingTable').deleteRow(1);    
  }
}
/* End Ranking Section */

function exitGameButton(){
  swal( this.playerLogged.playerName + ", are you sure you want to exit?", {
    buttons: {
      cancel : "Continue playing", 
      true : "Exit"
    },
  })
  .then((value) => {
    if(value){
      exitGame();
    }
    
  });
}

function exitGame() {
  toggleDiceGame();
  this.playerLogged = undefined;
  this.dicesPlayed = [0, 0, 0, 0];
  this.isWin = undefined;
  document.getElementById("playerCanvasName").innerHTML = '';
  cleanRankingTable();
  cleanHistoryTable();
  this.diceRanking = [];
  updateWinner("");
  this.lastRollJson = undefined;
  document.getElementById('lastRollResult').innerHTML = " --- ";
}

