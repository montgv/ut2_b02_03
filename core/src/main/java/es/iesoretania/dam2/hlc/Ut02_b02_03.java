package es.iesoretania.dam2.hlc;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Ut02_b02_03 extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture image;
	private TextureRegion reposo, reposoIzq, reposoDcha;
	float posX, posY;

	@Override
	public void create() {
		batch = new SpriteBatch();
		image = new Texture("libgdx.png");
		reposo = new TextureRegion(image, 42, 0, 39, 43);
		reposoIzq = new TextureRegion(image, 0, 0, 39, 43);
		reposoDcha = new TextureRegion(image, 84, 0, 39, 43);

		posX = 320 - reposo.getRegionWidth() / 2.0f;
		posY = 240 - reposo.getRegionHeight() / 2.0f;
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		TextureRegion actual = reposo;

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			posX = posX - 400 * Gdx.graphics.getDeltaTime();
			actual = reposoIzq;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			posX = posX + 400 * Gdx.graphics.getDeltaTime();
			actual = reposoDcha;
		}

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