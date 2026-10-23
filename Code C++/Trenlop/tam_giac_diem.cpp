#include<iostream>
#include<cmath>
using namespace std;
class Diem{
    protected: 
    float x,y;
    public : 
    void nhap(){
        cout<<" nhap lan luot toa do x y ";
        cin >>x>>y;

    }
    void xuat(){
        cout<<"(" << x <<";" <<y <<" )"<<endl;
    }
    friend float khoangcach(Diem d1,Diem d2){
         float kc=sqrt((d1.x-d2.x)*(d1.x-d2.x)+(d1.y-d2.y)*(d1.y-d2.y));
         return kc;
    }
};
class Tamgiac {
   protected : 
   Diem d1,d2,d3;
   int a,b,c;  // do dai 3 canh 
   public :
   void nhap(){
        cout<<"nhap diem d1 " ;
        d1.nhap();
        cout<<"nhap diem d2" ;
        d2.nhap();
        cout<<"nhap diem d3";
        d3.nhap();
   }
   void dodai(){
       a=khoangcach(d1,d2);
       b=khoangcach(d2,d3);
       c=khoangcach(d1,d3);
   }
   void checktg(){
     a=khoangcach(d1,d2);
       b=khoangcach(d2,d3);
       c=khoangcach(d1,d3);
      if(a+b>c && a+c>b && b+c>a){
        cout<<"la tam giac ";

         if(a==b && b==c){
            cout<<"deu" <<endl;
         }
         else if(a==b || b==c || a==c){
            cout<<"can" << endl;
         }
         else if(a*a+b*b==c*c || a*a+c*c==b*b || b*b+c*c==a*a){
            cout<<"vuong" << endl;
         }
         else if((a*a+b*b==c*c || a*a+c*c==b*b || b*b+c*c==a*a)&&(a==b || b==c || a==c)){
            cout<< " vuong can" <<endl;
         }
         else
          cout<<" thuong" << endl;
      }
      else 
      cout<<" khong phai la tam giac" << endl;
   }
};
int main(){
    Tamgiac a;
    a.nhap();
    a.checktg();
}