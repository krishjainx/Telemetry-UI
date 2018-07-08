const {app, BrowserWindow} = require('electron')
require('electron-reload')(__dirname);

let win

function createWindow () {
    // Create the browser window.
    win = new BrowserWindow({width: 1024, height: 768})

    win.loadFile('index.html')

    //win.webContents.openDevTools()

    win.on('closed', () => {
      win = null
    })
}

app.on('ready', createWindow)
app.on('window-all-closed', () => { app.quit() })
app.on('activate', () => { if (win === null) { createWindow() }})
