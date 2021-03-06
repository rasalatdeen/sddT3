package edu.uco.sdd.t3.gameboard;

import edu.uco.sdd.t3.R;
import edu.uco.sdd.t3.R.layout;
import edu.uco.sdd.t3.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameplayView extends Activity implements OnMarkerPlacedListener, OnGameOverListener {

	private Game mCurrentGame;
	private Player mPlayer1;
	private Player mPlayer2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameplay_view_3x3);
		int boardSize = 3;
		mCurrentGame = new Game(this, boardSize);
		mCurrentGame.setMarkerPlacedListener(this);
		mCurrentGame.setGameVictoryListener(this);
		mPlayer1 = mCurrentGame.getPlayer1();
		mPlayer2 = mCurrentGame.getPlayer2();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gameplay_view, menu);
		return true;
	}

	public boolean onButtonClicked(View v) {
		int row = -1;
		int col = -1;
		int buttonId = v.getId();
		switch (buttonId) {
			/* ROW 1 *****************************/
			case R.id.row1col1:
				row = 0;
				col = 0;
				break;
			case R.id.row1col2:
				row = 0;
				col = 1;
				break;
			case R.id.row1col3:
				row = 0;
				col = 2;
				break;
			case R.id.row1col4:
				row = 0;
				col = 3;
				break;
			case R.id.row1col5:
				row = 0;
				col = 4;
				break;
			/* ROW 2 *****************************/
			case R.id.row2col1:
				row = 1;
				col = 0;
				break;
			case R.id.row2col2:
				row = 1;
				col = 1;
				break;
			case R.id.row2col3:
				row = 1;
				col = 2;
				break;
			case R.id.row2col4:
				row = 1;
				col = 3;
				break;
			case R.id.row2col5:
				row = 1;
				col = 4;
				break;
			/* ROW 3 *****************************/
			case R.id.row3col1:
				row = 2;
				col = 0;
				break;
			case R.id.row3col2:
				row = 2;
				col = 1;
				break;
			case R.id.row3col3:
				row = 2;
				col = 2;
				break;
			case R.id.row3col4:
				row = 2;
				col = 3;
				break;
			case R.id.row3col5:
				row = 2;
				col = 4;
				break;
			/* ROW 4 *****************************/
			case R.id.row4col1:
				row = 3;
				col = 0;
				break;
			case R.id.row4col2:
				row = 3;
				col = 1;
				break;
			case R.id.row4col3:
				row = 3;
				col = 2;
				break;
			case R.id.row4col4:
				row = 3;
				col = 3;
				break;
			case R.id.row4col5:
				row = 3;
				col = 4;
				break;
			/* ROW 5 *****************************/
			case R.id.row5col1:
				row = 4;
				col = 0;
				break;
			case R.id.row5col2:
				row = 4;
				col = 1;
				break;
			case R.id.row5col3:
				row = 4;
				col = 2;
				break;
			case R.id.row5col4:
				row = 4;
				col = 3;
				break;
			case R.id.row5col5:
				row = 4;
				col = 4;
				break;
		}
		placeMarker(row, col);
		return true;
	}

	@Override
	public void onMarkerPlaced(MoveAction action) {
		Marker markerToPlace;
		int playerId = action.getPlayerId();
		if (playerId == mPlayer1.getId()) {
			markerToPlace = mPlayer1.getMarker();
		} else {
			markerToPlace = mPlayer2.getMarker();
		} 
		Drawable markerImage = markerToPlace.getDrawable();
		int row = action.getX();
		int column = action.getY();
		ImageButton imageToUpdate = getImageButtonAtLocation(row, column);
		imageToUpdate.setImageDrawable(markerImage);
	}

	private ImageButton getImageButtonAtLocation(int row, int column) {
		ImageButton buttonToReturn = null;
		if (row == 0) {
			if (column == 0) {
				buttonToReturn = (ImageButton) findViewById(R.id.row1col1);
			} else if (column == 1) {
				buttonToReturn = (ImageButton) findViewById(R.id.row1col2);
			} else if (column == 2) {
				buttonToReturn = (ImageButton) findViewById(R.id.row1col3);
			} else if (column == 3) {
				buttonToReturn = (ImageButton) findViewById(R.id.row1col4);
			} else if (column == 4) {
				buttonToReturn = (ImageButton) findViewById(R.id.row1col5);
			}
		} else if (row == 1) {
			if (column == 0) {
				buttonToReturn = (ImageButton) findViewById(R.id.row2col1);
			} else if (column == 1) {
				buttonToReturn = (ImageButton) findViewById(R.id.row2col2);
			} else if (column == 2) {
				buttonToReturn = (ImageButton) findViewById(R.id.row2col3);
			} else if (column == 3) {
				buttonToReturn = (ImageButton) findViewById(R.id.row2col4);
			} else if (column == 4) {
				buttonToReturn = (ImageButton) findViewById(R.id.row2col5);
			}
		} else if (row == 2) {
			if (column == 0) {
				buttonToReturn = (ImageButton) findViewById(R.id.row3col1);
			} else if (column == 1) {
				buttonToReturn = (ImageButton) findViewById(R.id.row3col2);
			} else if (column == 2) {
				buttonToReturn = (ImageButton) findViewById(R.id.row3col3);
			} else if (column == 3) {
				buttonToReturn = (ImageButton) findViewById(R.id.row3col4);
			} else if (column == 4) {
				buttonToReturn = (ImageButton) findViewById(R.id.row3col5);
			}
		} else if (row == 3) {
			if (column == 0) {
				buttonToReturn = (ImageButton) findViewById(R.id.row4col1);
			} else if (column == 1) {
				buttonToReturn = (ImageButton) findViewById(R.id.row4col2);
			} else if (column == 2) {
				buttonToReturn = (ImageButton) findViewById(R.id.row4col3);
			} else if (column == 3) {
				buttonToReturn = (ImageButton) findViewById(R.id.row4col4);
			} else if (column == 4) {
				buttonToReturn = (ImageButton) findViewById(R.id.row4col5);
			}
		} else if (row == 4) {
			if (column == 0) {
				buttonToReturn = (ImageButton) findViewById(R.id.row5col1);
			} else if (column == 1) {
				buttonToReturn = (ImageButton) findViewById(R.id.row5col2);
			} else if (column == 2) {
				buttonToReturn = (ImageButton) findViewById(R.id.row5col3);
			} else if (column == 3) {
				buttonToReturn = (ImageButton) findViewById(R.id.row5col4);
			} else if (column == 4) {
				buttonToReturn = (ImageButton) findViewById(R.id.row5col5);
			}
		}
		return buttonToReturn;
	}

	private void placeMarker(int row, int column) {
		if (mCurrentGame.getGameState() == Game.State.PLAYER_1_TURN) {
			Log.d("Player 1", "row = " + row + " col = " + column);
			mPlayer1.placeMarker(row, column);
		} else if (mCurrentGame.getGameState() == Game.State.PLAYER_2_TURN) {
			Log.d("Player 2", "row = " + row + " col = " + column);
			mPlayer2.placeMarker(row, column);
		}
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.new_game:
			newGame();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void newGame() {
		setContentView(R.layout.activity_gameplay_view_3x3);
		int boardSize = 3;
		mCurrentGame = new Game(this, boardSize);
		mCurrentGame.setMarkerPlacedListener(this);
		mCurrentGame.setGameVictoryListener(this);
		mPlayer1 = mCurrentGame.getPlayer1();
		mPlayer2 = mCurrentGame.getPlayer2();
	}

	@Override
	public void onGameOver(String message) {
		TextView gameMessage = (TextView) findViewById(R.id.victoryText);
		gameMessage.setText(message);
	}

}
