package com.example.calculadorajava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    private EditText e1,e2;
    private int count=0;
    private String expression="";
    private String text="";
    private Double result=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        e1=findViewById(R.id.editText1);
        e2=findViewById(R.id.editText2);

    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn_0:

                e2.setText(e2.getText()+"0");
                break;

            case R.id.btn_1:
                e2.setText(e2.getText()+"1");
                break;

            case R.id.btn_2:
                e2.setText(e2.getText()+"2");
                break;

            case R.id.btn_3:
                e2.setText(e2.getText()+"3");
                break;


            case R.id.btn_4:
                e2.setText(e2.getText()+"4");
                break;

            case R.id.btn_5:
                e2.setText(e2.getText()+"5");
                break;

            case R.id.btn_6:
                e2.setText(e2.getText()+"6");
                break;

            case R.id.btn_7:
                e2.setText(e2.getText()+"7");
                break;

            case R.id.btn_8:
                e2.setText(e2.getText()+"8");
                break;

            case R.id.btn_9:
                e2.setText(e2.getText()+"9");
                break;

            case R.id.btn_decimal:
                if(count==0 && e2.length()!=0)
                {
                    e2.setText(e2.getText()+".");
                    count++;
                }
                break;

            case R.id.clear:
                e1.setText("");
                e2.setText("");
                count=0;
                expression="";
                break;

            case R.id.backSpace:
                text=e2.getText().toString();
                if(text.length()>0)
                {
                    if(text.endsWith("."))
                    {
                        count=0;
                    }
                    String newText=text.substring(0,text.length()-1);
                    //to delete the data contained in the brackets at once
                    if(text.endsWith(")"))
                    {
                        char []a=text.toCharArray();
                        int pos=a.length-2;
                        int counter=1;
                        //to find the opening bracket position
                        for(int i=a.length-2;i>=0;i--)
                        {
                            if(a[i]==')')
                            {
                                counter++;
                            }
                            else if(a[i]=='(')
                            {
                                counter--;
                            }
                            //if decimal is deleted b/w brackets then count should be zero
                            else if(a[i]=='.')
                            {
                                count=0;
                            }
                            //if opening bracket pair for the last bracket is found
                            if(counter==0)
                            {
                                pos=i;
                                break;
                            }
                        }
                        newText=text.substring(0,pos);
                    }
                    //if e2 edit text contains only - sign or sqrt at last then clear the edit text e2
                    if(newText.equals("-")||newText.endsWith("sqrt"))
                    {
                        newText="";
                    }
                    //if pow sign is left at the last
                    else if(newText.endsWith("^"))
                        newText=newText.substring(0,newText.length()-1);

                    e2.setText(newText);
                }
                break;

            case R.id.btn_plus:
                operationClicked("+");
                break;

            case R.id.btn_minus:
                operationClicked("-");
                break;

            case R.id.btn_divide:
                operationClicked("/");
                break;

            case R.id.multiply:
                operationClicked("*");
                break;

//            case R.id.btn_sqrt:
//                if(e2.length()!=0)
//                {
//                    text=e2.getText().toString();
//                    e2.setText("sqrt(" + text + ")");
//                }
//                break;
//
//            case R.id.square:
//                if(e2.length()!=0)
//                {
//                    text=e2.getText().toString();
//                    e2.setText("("+text+")^2");
//                }
//                break;

//            case R.id.posneg:
//                if(e2.length()!=0)
//                {
//                    String s=e2.getText().toString();
//                    char arr[]=s.toCharArray();
//                    if(arr[0]=='-')
//                        e2.setText(s.substring(1,s.length()));
//                    else
//                        e2.setText("-"+s);
//                }
//                break;

            case R.id.btn_equals:
                /*for more knowledge on DoubleEvaluator and its tutorial go to the below link
                http://javaluator.sourceforge.net/en/home/*/
                if(e2.length()!=0)
                {
                    text=e2.getText().toString();
                    expression=e1.getText().toString()+text;
                }
                e1.setText("");
                if(expression.length()==0)
                    expression="0.0";
//                DoubleEvaluator evaluator = new DoubleEvaluator();
                try
                {
                    //evaluate the expression
                   // result=new ExtendedDoubleEvaluator().evaluate(expression);
                    //insert expression and result in sqlite database if expression is valid and not 0.0
//                    if(!expression.equals("0.0"))
//                        dbHelper.insert("STANDARD",expression+" = "+result);
//                    e2.setText(result+"");
                }
                catch (Exception e)
                {
                    e2.setText("Invalid Expression");
                    e1.setText("");
                    expression="";
                    e.printStackTrace();
                }
                break;

//            case R.id.openBracket:
//                e1.setText(e1.getText()+"(");
//                break;
//
//            case R.id.closeBracket:
//                e1.setText(e1.getText()+")");
//                break;
//
//            case R.id.history:
//                Intent i=new Intent(this,History.class);
//                i.putExtra("calcName","STANDARD");
//                startActivity(i);
//                break;
        }
    }

    private void operationClicked(String op)
    {
        if(e2.length()!=0)
        {
            String text=e2.getText().toString();
            e1.setText(e1.getText() + text+op);
            e2.setText("");
            count=0;
        }
        else
        {
            String text=e1.getText().toString();
            if(text.length()>0)
            {
                String newText=text.substring(0,text.length()-1)+op;
                e1.setText(newText);
            }
        }
    }
}