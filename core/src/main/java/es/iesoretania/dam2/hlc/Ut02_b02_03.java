package es.iesoretania.dam2.hlc;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Ut02_b02_03 extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture image;
	private TextureRegion reposo, reposoIzq, reposoDcha;
	private TextureRegion reposoArriba, reposoArribaIzq, reposoArribaDcha;
	private TextureRegion reposoAbajo, reposoAbajoIzq, reposoAbajoDcha;
	Sprite nave;
	@Override
	public void create() {
		batch = new SpriteBatch();
		image = new Texture("spacetheme.png");
		reposo = new TextureRegion(image, 42, 0, 39, 43);
		reposoIzq = new TextureRegion(image, 0, 0, 39, 43);
		reposoDcha = new TextureRegion(image, 84, 0, 39, 43);
		reposoArriba = new TextureRegion(image, 42, 43, 39, 43);
		reposoArribaIzq = new TextureRegion(image, 0, 43, 39, 43);
		reposoArribaDcha = new TextureRegion(image, 84, 43, 39, 43);
		reposoAbajo = new TextureRegion(image, 42, 86, 39, 43);
		reposoAbajoIzq = new TextureRegion(image, 0, 86, 39, 43);
		reposoAbajoDcha = new TextureRegion(image, 84, 86, 39, 43);

		nave = new Sprite();
		nave.setX(320 - reposo.getRegionWidth() / 2.0f);
		nave.setY(240 - reposo.getRegionHeight() / 2.0f);
		nave.setSize(39, 43);

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		TextureRegion actual = reposo;

		float posX = nave.getX();
		float posY = nave.getY();

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			posX = posX - 400 * Gdx.graphics.getDeltaTime();
			actual = reposoIzq;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			posX = posX + 400 * Gdx.graphics.getDeltaTime();
			actual = reposoDcha;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			posX = posX - 400 * Gdx.graphics.getDeltaTime();
			actual = reposoArriba;
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				actual = reposoArribaIzq;
			} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				actual = reposoArribaDcha;
			}
		} else {
			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				posX = posX + 400 * Gdx.graphics.getDeltaTime();
				actual = reposoAbajo;
				if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
					actual = reposoAbajoIzq;
				} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
					actual = reposoAbajoDcha;
				}
			}
		}

		if (nave.getX() < 0) nave.setX(0);
		if (nave.getY() < 0) nave.setY(0);
		if (nave.getX() > 640 - nave.);

		nave.setX(pos);

		batch.begin();
		batch.draw(actual, posX, posY);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		image.dispose();
	}
}