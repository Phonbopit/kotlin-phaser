
package examples.camera

import Koala.initKoala
import Phaser.*

class FollowStyles: State() {
	
	//var game = Phaser.Game(800, 600, Phaser.CANVAS, "phaser-example", object{ var  preload= preload;  var  create= create;  var  update= update;  var  render= render })
	
	lateinit var ufo:Sprite
	var Keys = Phaser.Keyboard
	var speed = 4
	var style = "default"
	lateinit var cursors:CursorKeys
	
	override fun preload() {
	
	    game.load.image("ground", "assets/tests/ground-2x.png")
	    game.load.image("river", "assets/tests/river-2x.png")
	    game.load.image("sky", "assets/tests/sky-2x.png")
	    game.load.image("cloud0", "assets/tests/cloud-big-2x.png")
	    game.load.image("cloud1", "assets/tests/cloud-narrow-2x.png")
	    game.load.image("cloud2", "assets/tests/cloud-small-2x.png")
	    game.load.image("ufo","assets/sprites/ufo.png")
	    game.load.image("baddie","assets/sprites/space-baddie.png")
	    game.load.spritesheet("button", "assets/buttons/follow-style-button.png", 224, 70)
	
	}
	
	override fun create() {
	
	    //  Make the world larger than the actual canvas
	    game.world.setBounds(0, 0, 1400, 1400)
	
	    for (i in 0..10-1)
	    {
	        game.add.sprite(game.world.randomX, game.world.randomY, "baddie")
	    }
	
	    //  Background images
	    game.add.tileSprite(0, 0, 1400, 600, "sky")
	    game.add.sprite(0, 360, "ground")
	    game.add.sprite(0, 400, "river")
	    game.add.sprite(200, 120, "cloud0")
	    game.add.sprite(-60, 120, "cloud1")
	    game.add.sprite(900, 170, "cloud2")
	
	    // ufo sprite
	    ufo = game.add.sprite(300, 240, "ufo")
	
	    //registration point
	    ufo.anchor.setTo(0.5, 0.5)
	
	    game.camera.follow(ufo)
	
	    // follow style switch buttons
	    val btn0 = game.add.button(6, 40, "button", this::lockonFollow,this, 0, 0, 0)
		val btn1 = game.add.button(6, 120, "button", this::platformerFollow,this, 1, 1, 1)
		val btn2 = game.add.button(6, 200, "button", this::topdownFollow,this, 2, 2, 2)
		val btn3 = game.add.button(6, 280, "button", this::topdownTightFollow,this, 3, 3, 3)
	
	    cursors = game.input.keyboard.createCursorKeys()
	
	}
	
	fun lockonFollow() {
	    game.camera.follow(ufo, Phaser.Camera.FOLLOW_LOCKON)
	    style = "STYLE_LOCKON"
	}
	
	fun platformerFollow() {
	    game.camera.follow(ufo, Phaser.Camera.FOLLOW_PLATFORMER)
	    style = "STYLE_PLATFORMER"
	}
	
	fun topdownFollow() {
	    game.camera.follow(ufo, Phaser.Camera.FOLLOW_TOPDOWN)
	    style = "STYLE_TOPDOWN"
	}
	
	fun topdownTightFollow() {
	    game.camera.follow(ufo, Phaser.Camera.FOLLOW_TOPDOWN_TIGHT)
	    style = "STYLE_TOPDOWN_TIGHT"
	}
	
	override fun update() {
	
	    if (cursors.left.isDown)
	    {
	        ufo.x -= speed
	        ufo.angle = -15.0
	    }
	    else if (cursors.right.isDown)
	    {
	        ufo.x += speed
	        ufo.angle = 15.0
	    }
	    else if (cursors.up.isDown)
	    {
	        ufo.y -= speed
	    }
	    else if (cursors.down.isDown)
	    {
	        ufo.y += speed
	    }
	    else
	    {
	        ufo.angle = 0.0
	    }
	
	}
	
	override fun render() {
	
	    game.debug.text("Click buttons to switch follow styles", 32, 32)
	    game.debug.text("Current style: " + style, 32, 64)
	
	}
}