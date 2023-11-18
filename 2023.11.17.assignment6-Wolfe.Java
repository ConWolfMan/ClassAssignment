// done first to reduce potential issues
void setup()
{
 size(800, 800);
}

//////////////////////////////////////////// int/float variables ////////////////////////////////////////

///////////////// event controller variables ////////////
int stageSelect = 0;

///////////////// eye variables ////////////////////////
// Left and/or Right eye variables
// used in the function that builds the left eye //
float leftEyeX = 800/4;
float leftEyeY = 100;
float leftBigPupilX = leftEyeX;
float leftBigPupilY = leftEyeY;
float leftSmlPupilX = leftEyeX;
float leftSmlPupilY = leftEyeY;
// used in the function that builds the right eye //
float rightEyeX = 800/1.33;
float rightEyeY = 100;
float rightBigPupilX = rightEyeX;
float rightBigPupilY = rightEyeY;
float rightSmlPupilX = rightEyeX;
float rightSmlPupilY = rightEyeY;
/// universal eye variables ///
// used in the function that builds the eye //
int eyeHght = 115;
int eyeLngth = 250;
// color of the eye //
int eyeRed = 225;
int eyeGreen = 200;
int eyeBlue = 175;
/// used in the function that builds the pupils ///
int bigPupilDiam = 100;
// color of the bigPupil(s) //
int bigPupilRed = 75;
int bigPupilGreen = 255;
int bigPupilBlue = 255;
//makes the inner, black, part of the pupil size//
int smlPupilDiam = bigPupilDiam/2;
// color of the small pupils //
int smlPupilRed = 0;
int smlPupilGreen = 0;
int smlPupilBlue = 0;
// used to help the sml pupil look where I want //
float leftEyeAngle = 0.0;
float rightEyeAngle = 0.0;
float smlPupilRadius = bigPupilDiam/4;
// used to determine what the eye is looking at
float eyeLookX;
float eyeLookY;

////////////////// bounds variables //////////
int ballLeftBounds = -100;
int ballRightBounds = 900;
float boxLeftBounds = -285/2;
float boxRightBounds = 800 + 285/2;
float fishLeftBounds = -148;
float fishRightBounds = 850;

////////////////// ball variables //////////
// used for the ball's (x,y)
float ballX = ballLeftBounds;
float ballY = 600;
// used for the ball's size
float ballSize = 200;
// color of the ball
int ballRed = 255;
int ballGreen = 160;
int ballBlue = 56;

//////////////// box variables ///////////////
// used for the ball's (x,y)
float boxX = boxRightBounds;
float boxY = 600;
// used to define the ball's size
float boxSize = 285;
// color of the box
int boxRed = 156;
int boxGreen = 52;
int boxBlue = 53;

///////////////// fish variables ////////////////
//defines the size of the fish
float fishBodySize = 100;
// defines the "true" (x,y) of the fish's body, fBX and fBY serve no real purpose other than making edits cleaner and easier to read
float fBX = fishRightBounds;
float fBY = 400;
// defines the (x,y) of the fish's body, square (x,y) is in the top left so they are kept seperate to bring them toward the center
float fishBodyX = fBX - fishBodySize/2;
float fishBodyY = fBY - fishBodySize/2;
// defines the size and (x,y) of the fish's tail
float fishTailP1X = fBX + fishBodySize/2 - 2;
float fishTailP1Y = fBY;
float fishTailP2X = fishTailP1X + fishBodySize/2;
float fishTailP2Y = fBY - fishBodySize/2;
float fishTailP3X = fishTailP2X;
float fishTailP3Y = fBY + fishBodySize/2;
// makes the little fish eye
float fishEyeX;
float fishEyeY = fBY - fishBodySize/6;
float fishEyeSize = 15;
// defines the color of the fish
// salmon pink color for the body
int fishBodyRed = 250;
int fishBodyGreen = 128;
int fishBodyBlue = 114;
// soft cyan color for the body
int fishTailRed = 178;
int fishTailGreen = 243;
int fishTailBlue = 243;
// black color for the eye
int fishEyeRed = 0;
int fishEyeGreen = 0;
int fishEyeBlue = 0;

/// used to determine the color of the background ///
int bckRed = 50;
int bckGreen = 150;
int bckBlue = 225;

///////////////////////////////////////////////// int/float functions /////////////////////////////////////////

/////////////// eye functions ////////////////////
float RightEyeStareX(float centerX, float radius, float angle)
{
  float newX;
  newX = centerX + radius * angle;
  return newX;
}

float RightEyeStareY(float centerY, float radius, float angle)
{
  float newY;
  newY = centerY + radius * angle;
  return newY;
}

float LeftEyeStareX(float centerX, float radius, float angle)
{
  float newX;
  newX = centerX + radius * angle;
  return newX;
}

float LeftEyeStareY(float centerY, float radius, float angle)
{
  float newY;
  newY = centerY + radius * angle;
  return newY;
}


///////////////////////////////////////////////// void functions //////////////////////////////////////////////
void HideEverything()
{
   background(bckRed, bckGreen, bckBlue);
}

///////////// event controller function ////////////
void ObjectSelector()
{
  switch(stageSelect)
  {    
// in stage 0 we have the ball go across the screen    
    case 0:
    {
      BallObject();
      eyeLookX = ballX;
      eyeLookY = ballY;
      BallCheck();
    }
    break;

// in stage 2 we have a box go across the screen
    case 1:
    {
     BoxObject();
     eyeLookX = boxX;
     eyeLookY = boxY;
     BoxCheck();
    }
    break;
    
// darts to look at the fish
  case 2:
  {
    DartMoveCheck();
  }
  break;
    
// in stage 2 we have the fish going across the screen
    case 3:
      {
        FishObject();
        eyeLookX = fBX;
        eyeLookY = fBY;
        FishCheck();
    }
      break; 
      
    default:
    break;
  }
}

void BallObject()
{
 BallBuild();
 BallMove();
}

void BoxObject()
{
 BoxBuild();
 BoxMove();
}

void FishObject()
{
 FishBuild();
 FishMove();
}

void DartMoveCheck()
{
  if (eyeLookX < fishRightBounds)
    {
      fill(0);
      circle(eyeLookX, eyeLookY, 10);
      eyeLookX += 5;
      eyeLookY = fBY;
    } else {
      stageSelect++;
  }
}

////////////// eye functions //////////////
void EyeBuild()
{
  fill(eyeRed, eyeGreen, eyeBlue);

// buids the left eye // 
  ellipse(leftEyeX, leftEyeY, eyeLngth, eyeHght); 

// builds the right eye //
  ellipse(rightEyeX, rightEyeY, eyeLngth, eyeHght);
}

void PupilBuild()
{
 // color of the big pupil //
 fill(bigPupilRed, bigPupilGreen, bigPupilBlue);
 // builds the left big pupil //
 circle(leftBigPupilX, leftBigPupilY, bigPupilDiam);
 // builds the right bif pupil //
 circle(rightBigPupilX, rightBigPupilY, bigPupilDiam);
 
 // color of the small pupil //
 fill(smlPupilRed, smlPupilGreen, smlPupilRed);
 // builds the left small pupil //
 circle(leftSmlPupilX, leftSmlPupilY, smlPupilDiam);
 // builds the right small pupil //
 circle(rightSmlPupilX, rightSmlPupilY, smlPupilDiam);
}

void PupilStare()
{
// staring mechanics of the left eye //
  // defines where the eye(s) stare
  leftEyeAngle = atan2(eyeLookY-leftBigPupilY, eyeLookX-leftBigPupilX);
  
  // puts the pupil on the circle where we want //
  leftSmlPupilX = LeftEyeStareX(leftBigPupilX, smlPupilRadius, cos(leftEyeAngle));
  leftSmlPupilY = LeftEyeStareY(leftBigPupilY, smlPupilRadius, sin(leftEyeAngle));

// staring mechanics of the right eye //
  // defines where the eye(s) stare
  rightEyeAngle = atan2(eyeLookY-rightBigPupilY, eyeLookX-rightBigPupilX);
  
  // puts the pupil on the circle where we want //
  rightSmlPupilX = RightEyeStareX(rightBigPupilX, smlPupilRadius, cos(rightEyeAngle));
  rightSmlPupilY = RightEyeStareY(rightBigPupilY, smlPupilRadius, sin(rightEyeAngle));

}

///////////////// ball function ///////////////
void BallBuild()
{
  // builds the ball
  fill(ballRed, ballGreen, ballBlue);
  circle(ballX, ballY, ballSize);
}

void BallMove()
{
 if (ballX < ballRightBounds)
   ballX += 5;
}

void BallCheck()
{
 if (ballX >= ballRightBounds)
   stageSelect++; 
}

///////////////// box functions //////////////
void BoxBuild()
{
  // builds the box
  fill(boxRed, boxGreen, boxBlue);
  square(boxX, boxY, boxSize);
}

void BoxMove()
{
  if (boxX > boxLeftBounds)
    boxX -= 3;
}

void BoxCheck()
{
  if (boxX <= boxLeftBounds)
    stageSelect++;
}

///////////////// fish functions //////////////
void FishBuild()
{
 // tail of the fish
 fill(fishTailRed, fishTailGreen, fishTailBlue);
 triangle(fishTailP1X, fishTailP1Y, fishTailP2X, fishTailP2Y, fishTailP3X, fishTailP3Y);
  
 // body of the fish
 fill(fishBodyRed, fishBodyGreen, fishBodyBlue);
 square(fishBodyX, fishBodyY, fishBodySize);
 
 // eye of the fish
 fill(fishEyeRed, fishEyeGreen, fishEyeBlue);
 circle(fishEyeX, fishEyeY, fishEyeSize);
}

void FishMove()
{
  if (fBX > fishLeftBounds)
  fBX--;
  
  // the program needs to constantly refresh where the fish x coordinates are
  fishBodyX = fBX - fishBodySize/2;
  fishTailP1X = fBX + fishBodySize/2 - 2;
  fishTailP2X = fishTailP1X + fishBodySize/2;
  fishTailP3X = fishTailP2X;
  fishEyeX = fBX;
  
}

void FishCheck()
{
  if (fBX <= fishLeftBounds)
   stageSelect++;
}

///////////////// draw function //////////////
void draw()
{
  HideEverything();
  // selects which objects go across the screen
  ObjectSelector();
  // eye functions
  EyeBuild();
  PupilBuild();
  PupilStare();
}
