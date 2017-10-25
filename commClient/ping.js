var connection = new WebSocket('ws://10.42.0.1:4444');
var actions = 'No action taken';

connection.onopen = function () {
    console.log('Connected!');
    connection.send('Ping'); // Send the message 'Ping' to the server
};

// Log errors
connection.onerror = function (error) {
    console.log('WebSocket Error ' + error);
};

// Log messages from the server
connection.onmessage = function (e) {
    console.log('Server: ' + e.data);
};


setInterval(function () {
    console.log('test')
    connection.send(actions);
    }, 2000);

