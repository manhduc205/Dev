#include <iostream>
#include <string>
using namespace std;
class PRODUCT{
    protected:
        string tensp, DVT;
        double gia;
    public:
        virtual void nhap()= 0;
        virtual void in(){
            cout << "Ten san pham: " << tensp << endl;
            cout << "Gia: " << gia << endl;
            cout << "Don vi tinh: " << endl;
        }
};

class ELECTRONIC : public PRODUCT{
    protected:
        int nambaohanh;
    public:
    void nhap() override{

        cout << "Nhap ten san pham: ";
        cin.ignore();
        getline(cin, tensp);
        cout << "Nhap gia tien: ";
        cin >> gia;
        cin.ignore();
        cout << "Nhap don vi tinh: ";
        getline(cin, DVT);
        cout << "Nhap vao nam bao hanh: " ;
        cin >> nambaohanh;
    }
    void in() override{
        PRODUCT::in();
        cout << "Nam bao hanh: " << nambaohanh;

    }
    int getNamBaoHanh(){
        return nambaohanh;
    }

};

class CLOTHING : public PRODUCT{
    private:
        string size, mausac, chatlieu;
    public:
        void in() override{
            PRODUCT::in();
            cout << "Size: " << size << endl;
            cout << "Mau sac: " << mausac << endl;
            cout << "Chat lieu: " << chatlieu << endl;
        }
};
int main(){
    int n; cout << "Nhap vao so san pham: " ;
    cin >> n;
    PRODUCT *pd;
    ELECTRONIC e[50];
    for(int i = 0; i < n ; i++){
        cout << "\nNhap thong tin san pham thu " << i + 1 << ":\n";
        pd = &e[i];
        pd->nhap();
    }
    for(int i = 0; i < n ; i++){
        cout << "\nThong tin san pham thu " << i + 1 << ":\n";
        pd = &e[i];
        pd->in();
    }
    int maxTemp= 0;
    for(int i = 0; i < n ; i++){
        if(e[i].getNamBaoHanh() < e[i+1].getNamBaoHanh()){
            maxTemp = i;
        }
    }
    cout << "\nThong tin san pham co nam bao hanh lop nhat: " << endl;
    e[maxTemp].in();
}