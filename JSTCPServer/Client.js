const net = require('net')
const prompt = require('prompt-sync')
const client = new net.Socket()
const port = 25565
const host = '192.168.1.6'

client.connect(port, host, function() {
    console.log('Connected')
    client.write("Hello From Client " + client.address().address + "::"+ client.address().port+"\n")
    
})
client.on('data', (data)=>{
    console.log('server :'+ data)
})
client.on('close',()=>{
    console.log('close')
})