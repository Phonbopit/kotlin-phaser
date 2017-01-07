
package examples.loader

import Koala.initKoala
import Phaser.*

class LoadTextFile: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  render= render })
	
	override fun preload() {
	
	    //  Phaser can load Text files.
	
	    //  It does this using an XMLHttpRequest.
	    
	    //  If loading a file from outside of the domain in which the game is running 
	    //  a "Access-Control-Allow-Origin" header must be present on the server.
	    //  No parsing of the text file is performed, it"s literally just the raw data.
	
	    game.load.text("html", "http://phaser.io")
	
	}
	
	lateinit var text:List<String>
	
	override fun create() {
	
	    game.stage.backgroundColor = "#0072bc"
	
	    var html = game.cache.getText("html")
	
	    text = html.split("\n")
	
	}
	
	override fun render() {
	
	    for(i in 0..30-1)
	    {
	        game.debug.text(text[i], 32, i * 20)
	    }
	
	}
}