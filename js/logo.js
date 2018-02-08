function Triangle(a, b, c, strokeColor, fillColor) {
  this.pointA = a;
  this.pointB = b;
  this.pointC = c;
  this.strokeColor = (strokeColor === undefined)
    ? "#ffffff"
    : utils.parseColor(strokeColor);
  this.fillColor = (fillColor === undefined)
    ? "#ffffff" 
    : utils.parseColor(fillColor);
  this.alphaStroke = 1;
  this.alphaFill = 1;
}

Triangle.prototype.draw = function($) {
  $.save();
  $.strokeStyle = utils.colorToRGB(this.strokeColor, this.alphaStroke);
  $.fillStyle = utils.colorToRGB(this.fillColor, this.alphaFill);
  $.beginPath();
  $.moveTo(this.pointA.getScreenX(), this.pointA.getScreenY());
  $.lineTo(this.pointB.getScreenX(), this.pointB.getScreenY());
  $.lineTo(this.pointC.getScreenX(), this.pointC.getScreenY());
  $.closePath();
  $.lineWidth = 1;
  $.fill();
  $.stroke();
  $.restore();
};

function load () {
  var canvas = document.getElementById('logo');
  var $ = canvas.getContext('2d');

  var mouse = utils.captureMouse(canvas);
  var points = [];
  var triangles = [];
  var fl = 120;
  var vpX = canvas.width * 0.5;
  var vpY = canvas.height * 0.35;
  var angleX;
  var angleY;
  var drawHeight = vpY;
  var drawWidth = vpY;

  points[0] = new Point3d(0, -drawHeight, 0);
  points[1] = new Point3d(drawWidth, drawHeight, -drawHeight);
  points[2] = new Point3d(-drawWidth, drawHeight, -drawHeight);
  points[3] = new Point3d(-drawWidth, drawHeight, drawHeight);
  points[4] = new Point3d(drawWidth, drawHeight, drawHeight);
  points[5] = new Point3d(0, drawHeight * 2, 0);
 
  points.forEach(function(point) {
    point.setVanishingPoint(vpX, vpY);
    point.setCenter(0, 0, drawWidth * 2);
  });

  triangles[0] = new Triangle(points[0], points[1], points[2], "#ffffff", "#363636");
  triangles[1] = new Triangle(points[0], points[2], points[3], "#ffffff", "#363636");
  triangles[2] = new Triangle(points[0], points[3], points[4], "#ffffff", "#363636");
  triangles[3] = new Triangle(points[0], points[4], points[1], "#ffffff", "#363636");
  triangles[4] = new Triangle(points[5], points[1], points[2], "#ffffff", "#363636");
  triangles[5] = new Triangle(points[5], points[2], points[3], "#ffffff", "#363636");
  triangles[6] = new Triangle(points[5], points[3], points[4], "#ffffff", "#363636");
  triangles[7] = new Triangle(points[5], points[4], points[1], "#ffffff", "#363636");

  function move(point) {
    point.rotateY(angleY);
  }

  function draw(triangle) {
    triangle.draw($);
  }

  (function drawFrame() {
    window.requestAnimationFrame(drawFrame, canvas);
    $.clearRect(0, 0, canvas.width, canvas.height);
    angleX = (mouse.y - vpY) * 0.00005;
    angleY = (mouse.x - vpX) * 0.00005;
    points.forEach(move);
    triangles.forEach(draw);
  }());
};

window.onresize = function() {
  load();
};

window.onload = function() {
  load();
};
