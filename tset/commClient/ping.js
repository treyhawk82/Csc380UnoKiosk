var connection = new WebSocket('ws://127.0.0.1:4444');
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
    var serverString = e.data;
    console.log(serverString);
    var serverStringArray = serverString.split('-');
    var topOfDiscardPile = serverStringArray[0];
    console.log(topOfDiscardPile + " = top of discard pile");
    var playerNumber = serverStringArray[1];
    console.log(playerNumber + " = current player number");
    var player0NoOfCards = serverStringArray[2];
    console.log(player0NoOfCards + " = player 0 # cards");
    var player1NoOfCards = serverStringArray[3];
    console.log(player1NoOfCards + " = player 1 # cards");
    var player2NoOfCards = serverStringArray[4];
    console.log(player2NoOfCards + " = player 2 # cards");
    var player3NoOfCards = serverStringArray[5];
    console.log(player3NoOfCards + " = player 3 # cards");
    var playerHand = serverStringArray[6];
    console.log(playerHand + " = complete hand of player " + playerNumber);
    var cardsArray = playerHand.split('x');
    for(var i = 0; i < cardsArray.length; i++){
        console.log(cardsArray[i] + " = card #" + i);
    }
};


setInterval(function () {
    console.log('test')
    connection.send(actions);
    }, 2000);

