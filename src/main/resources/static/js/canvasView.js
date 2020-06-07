

function setup() {

    var canvasMdk = createCanvas(windowWidth, windowHeight * 0.9);
    canvasMdk.parent('diceCanvas');
    background(0);
    frameRate(60);
}

function draw() {

    fill(255);
    circle(mouseX, mouseY, frameCount % 50 + 1 );

}
