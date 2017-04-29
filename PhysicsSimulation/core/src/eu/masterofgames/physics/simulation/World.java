package eu.masterofgames.physics.simulation;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {

    private static Vector2 GRAVITY = new Vector2(0, -9.81f); // Metres per Second
    public static float MAX_SPEED = 9.81f;

    private Array<Object> OBJECTS;

    public World() {
        OBJECTS = new Array<Object>();
    }

    public void createRectangle(int x, int y, int width, int height, Color color, boolean isStatic) {
        OBJECTS.add(new Rectangle(x, y, width, height, color, isStatic));
    }

    public void collisionDetection() {
        for (int a = 0; a < OBJECTS.size; a++) {
            for (int b = 0; b < OBJECTS.size; b++) {
                if (OBJECTS.get(a).equals(OBJECTS.get(b))) break;
                if (OBJECTS.get(a).boundingRectangle.overlaps(OBJECTS.get(b).boundingRectangle)) {
                    System.out.println("COLLISION RECTANGLE");
                    Polygon polygonA = new Polygon(OBJECTS.get(a).verticiesFloatArray);
                    Polygon polygonB = new Polygon(OBJECTS.get(b).verticiesFloatArray);
                    for (int i = 0; i < OBJECTS.get(a).verticies.length; i++) {
                        if (polygonB.contains(OBJECTS.get(a).verticies[i])) {
                            OBJECTS.get(a).collide();
                            System.out.println("COLLISION A");
                            return;
                        }
                    }
                    for (int i = 0; i < OBJECTS.get(b).verticies.length; i++) {
                        if (polygonA.contains(OBJECTS.get(b).verticies[i])) {
                            OBJECTS.get(b).collide();
                            System.out.println("COLLISION B");
                            return;
                        }
                    }
                }
            }
        }
    }

    public void handleInput() {

    }

    public void update(float deltaTime) {
        handleInput();

        for (Object objects : OBJECTS) {
            objects.update();
            objects.applyForce(GRAVITY);
        }

        collisionDetection();
    }

    public void render(SpriteBatch batch) {
        batch.begin();

        for (Object objects : OBJECTS) {
            objects.render();
        }

        batch.end();
    }
}
