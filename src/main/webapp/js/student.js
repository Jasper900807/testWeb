window.onload = function() {
	let canvas, ctx;
	//let WebSocket = new WebSocket("ws://10.0.101.65:8080/BradWeb/?");
	//let WebSocket = new WebSocket("ws://10.0.101.85:8080/testWeb/?");
	
	canvas = document.getElementById("myDrawer");
	ctx = canvas.getContext("2d");
	
	
	function clear() {
		ctx.clearRect(0, 0, canvas.width, canvas.height);
	};
	
	function newLine(x, y) {
		ctx.beginPath();
		ctx.lineWidth = 4;
		ctx.moveTo(x, y);
	};
	
	function drawLine(x, y) {
		let x = e.offsetX, y = e.offsetY;
		ctx.lineTo(x, y);
		ctx.stroke();
	};
} 