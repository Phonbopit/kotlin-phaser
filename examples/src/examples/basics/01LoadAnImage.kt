
package examples.basics


import Phaser.*

class E01LoadAnImage: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.AUTO, "phaser-example", { preload: preload, create: create })
	
	override fun preload() {
	
	    //  You can fill the preloader with as many assets as your game requires
	
	    //  Here we are loading an image. The first parameter is the unique
	    //  string by which we"ll identify the image later in our code.
	
	    //  The second parameter is the URL of the image (relative)
	    game.load.image("einstein", "assets/pics/ra_einstein.png")
	
	}
	
	override fun create() {
	
	    //  This creates a simple sprite that is using our loaded image and
	    //  displays it on-screen
	    game.add.sprite(0, 0, "einstein")
	
	}
}