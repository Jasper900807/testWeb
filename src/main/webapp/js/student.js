window.onload = function() {
	let canvas, ctx;
	//let WebSocket = new WebSocket("ws://10.0.101.65:8080/BradWeb/?");
	let webSocket = new WebSocket("ws://localhost:8080/testWeb/mycenter");
	let isConnect = false;
	
	webSocket.onopen = function() {
		console.log("onopen");
		isConnect = true;
	}
	
	webSocket.onmessage = function(e) {
		console.log("onmessage" + e.data);
		if(isConnect) {
			let mesgObj = JSON.parse(e.data);
			if (mesgObj.isClear) {
				clear();
			}
			else {
				if (mesgObj.isNewLine) {
					newLine(mesgObj.x, mesgObj.y);
				} 
				else {
					drawLine(mesgObj.x, mesgObj.y);
				}
			}
		}
	}
	
	webSocket.onclose = function() {
		isConnect = false;
	}
	
	webSocket.onerror = function(e) {
		console.log("ERROR:" + e.data);
	}
	
	
	// -----
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
		ctx.lineTo(x, y);
		ctx.stroke();
	};
} 