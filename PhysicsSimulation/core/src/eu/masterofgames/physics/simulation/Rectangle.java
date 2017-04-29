package eu.masterofgames.physics.simulation;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Rectangle extends Object {

    private com.badlogic.gdx.math.Rectangle rectangle;

    public Rectangle(int x, int y, int width, int height, Color color, boolean isStatic) {
        super(color, isStatic);
        rectangle = new com.badlogic.gdx.math.Rectangle(x, y, width, height);
        boundingRectangle = rectangle;
        position = new Vector2(x + width / 2, y + height / 2);
        verticies = new Vector2[] {
                new Vector2(rectangle.getX(), rectangle.getY()),
                new Vector2(rectangle.getX() + 100, rectangle.getY()),
                new Vector2(rectangle.getX(), rectangle.getY() + 100),
                new Vector2(rectangle.getX() + 100, rectangle.getY() + 100)
        };
        verticiesFloatArray = new float[] {
                verticies[0].x, verticies[0].y,
                verticies[1].x, verticies[1].y,
                verticies[2].x, verticies[2].y,
                verticies[3].x, verticies[3].y
        };
    }

    @Override
    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(color.r - 0.7f, color.g - 0.7f, color.b - 0.7f, color.a));
        shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.getWidth(), rectangle.getHeight());
        shapeRenderer.setColor(color);
        shapeRenderer.rect(rectangle.x + 4, rectangle.y + 4, rectangle.getWidth() - 8, rectangle.getHeight() - 8);
        shapeRenderer.end();
    }

    @Override
    public void update() {
        if (!isStatic) {
            position.add(velocity);
            velocity.add(acceleration);
            acceleration = new Vector2();
            rectangle.setPosition(position.x - rectangle.getWidth() / 2, position.y - rectangle.getHeight() / 2);
            verticies = new Vector2[]{
                    new Vector2(rectangle.getX(), rectangle.getY()),
                    new Vector2(rectangle.getX() + 100, rectangle.getY()),
                    new Vector2(rectangle.getX(), rectangle.getY() + 100),
                    new Vector2(rectangle.getX() + 100, rectangle.getY() + 100)
            };
            verticiesFloatArray = new float[]{
                    verticies[0].x, verticies[0].y,
                    verticies[1].x, verticies[1].y,
                    verticies[2].x, verticies[2].y,
                    verticies[3].x, verticies[3].y
            };
        }
    }

    @Override
    public void applyForce(Vector2 force) {
        acceleration.add(new Vector2(force.x * 0.02f, force.y * 0.02f));
    }
}
