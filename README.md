#in this project i will create a animated dialog box. At first we will create all xml files, so this is our custom dialog layout.


    <androidx.cardview.widget.CardView
        android:id="@+id/cardView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardCornerRadius="15dp"
        app:layout_constraintBottom_toBottomOf="parent"
        tools:ignore="MissingConstraints">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center_horizontal"
            android:orientation="vertical">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="40dp"
                android:text="Dialog Box"
                android:textColor="@color/colorPrimary"
                android:textSize="20sp"
                android:textStyle="bold" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="5dp"
                android:text="this is custom \nanimated dialog box"
                android:textAlignment="center"
                android:textSize="16sp" />

            <Button
                android:id="@+id/okButtonID"
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:layout_margin="20dp"
                android:background="@drawable/button_shape"
                android:text="OK"
                android:textColor="#fff" />

        </LinearLayout>

    </androidx.cardview.widget.CardView>

    <Button
        android:id="@+id/signButtonID"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:background="@drawable/sign_ic"
        app:layout_constraintBottom_toTopOf="@+id/cardView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/cardView"
        tools:ignore="MissingConstraints"
        android:visibility="gone"/>


#this is our open animation file, it will be in res/anim/open.xml file

    <translate
        android:duration="170"
        android:fromYDelta="-100%"
        android:toYDelta="5%"
        />

#this is our close animation file, it will be in res/anim/close.xml file

    <scale
        android:duration="170"
        android:fromXScale="1.0"
        android:fromYScale="1.0"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="0.0"
        android:toYScale="0.0" />

    <alpha
        android:duration="170"
        android:fromAlpha="1.0"
        android:interpolator="@android:anim/decelerate_interpolator"
        android:toAlpha="0.0" />

#this is popup button animation file, it will be  res/anim/button_anim.xml file

    <scale
        android:duration="170"
        android:fromXScale="0.0"
        android:fromYScale="0.0"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="1.2"
        android:toYScale="1.2" />

    <alpha
        android:duration="170"
        android:fromAlpha="0.0"
        android:interpolator="@android:anim/decelerate_interpolator"
        android:toAlpha="1.0" />
        
 #then create this style
 
    <style name="dialogAnimation">
        <item name="android:windowEnterAnimation">@anim/open</item>
        <item name="android:windowExitAnimation">@anim/close</item>
    </style>
    
 #now we can move to java code. This is our dialog box 
 
    public class DialogBox extends Dialog {

    private Button signButton;
    private Context context;
    public DialogBox(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_box_layout);

        signButton = findViewById(R.id.signButtonID);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //here is button animation implementation 
                Animation animation = AnimationUtils.loadAnimation(context,R.anim.button_animation);
                signButton.setVisibility(View.VISIBLE);
                signButton.setAnimation(animation);
            }
        }, 400);
        
        findViewById(R.id.okButtonID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
      }
    }
    
    
   #and then we call this dialog box in our Activity class.
   
    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.clickButtonID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBox dialogBox = new DialogBox(MainActivity.this);
                dialogBox.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                //here is dialog box open close animation.
                dialogBox.getWindow().getAttributes().windowAnimations = R.style.dialogAnimation;
                dialogBox.show();
            }
        });
      }
    }
