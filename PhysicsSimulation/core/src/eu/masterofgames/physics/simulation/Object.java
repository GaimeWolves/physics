package eu.masterofgames.physics.simulation;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Object {

    protected ShapeRenderer shapeRenderer;
    protected Color color;
    protected boolean isStatic;

    public Vector2 position;
    public Vector2 acceleration;
    public Vector2 velocity;
    public Rectangle boundingRectangle;
    public Vector2[] verticies;
    public float[] verticiesFloatArray;

    public Object(Color color, boolean isStatic) {
        shapeRenderer = new ShapeRenderer();
        this.color = color;
        this.isStatic = isStatic;
        acceleration = new Vector2();
        velocity = new Vector2();
        position = new Vector2();
        boundingRectangle = new Rectangle();
    }

    public void collide() {
        velocity = new Vector2(-velocity.x, -velocity.y);
    }

    public abstract void render();
    public abstract void update();
    public abstract void applyForce(Vector2 force);
}
