const net = require('net')
const ip = "192.168.1.6"
const port = 25565

const server = net.createServer();


let sockets = []

server.listen(port,ip,()=>{
    console.log("server running on " + port)
})


server.on('connection', function(sock) {
    console.log('CONNECTED: ' + sock.remoteAddress + ':' + sock.remotePort)
    sockets.push(sock)

    sock.on('data', function(data) {
        console.log('DATA ' + sock.remoteAddress + ': ' + data)
        // Write the data back to all the connected, the client will receive it as data from the server
        sockets.forEach(function(sock, index, array) {
            sock.write(sock.remoteAddress + ':' + sock.remotePort + " said " + data + '\n')
        })
    })
    sock.on('close', function(data) {
        let index = sockets.findIndex(function(o) {
            return o.remoteAddress === sock.remoteAddress && o.remotePort === sock.remotePort
        })
        if (index !== -1) sockets.splice(index, 1)
        console.log('CLOSED: ' + sock.remoteAddress + ' ' + sock.remotePort)
    })
    sock.on('error',(err)=>{
        console.log(err)
    })
})
setInterval(()=>{
    console.log("Clients :")
    sockets.forEach((sock)=>{
        console.log(sock.remoteAddress+":"+sock.remotePort)
    })

},5000)

// class Player {
//     constructor(socket,name=socket.remoteAddress.toString(),coin=0) {
//         this.socket = socket
//         this.name = name
//         this.coin = coin
//     }
//     addCoin(coin){
//         this.coin = coin
//     }
// }
