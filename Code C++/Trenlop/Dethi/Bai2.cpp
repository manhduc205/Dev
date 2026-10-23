/*
Câu 2: Viết chương trình thực hiện các yêu cầu sau:
Khai báo lớp đa thức với các thuộc tính: bậc đa thức, các hệ số tương ứng.
Xây dựng các phương thức: nhập, xuất một đối tượng đa thức.
Định nghĩa toán tử +, - hai đa thức. Thực hiện cộng, trừ hai đa thức và in kết quả ra màn hình.
// 1x^0+3x^1+4x^2
// 2x^0+5x^1+5x^2+5x^3+6x^4
*/
#include <iostream>
using namespace std;
class DaThuc{
    protected:
        int bacDt;
        int a[10] = {0};
    public:
        DaThuc(){
            bacDt = 0;
            a[bacDt] = 0;
        }
        DaThuc(int c, int b[10]){
            bacDt = c;
            for (int i = 0; i < c; i++) {
                a[i] = b[i];
            }
        }

        friend istream &operator >> (istream &is, DaThuc &dt){
            cout << "Nhap bac cua da thuc: ";
            is >> dt.bacDt;

            cout << "Nhap he so cua da thuc";
            for(int i = 0; i <= dt.bacDt; i++){
                is >> dt.a[i];
            }
            return is;
        } 
        friend ostream &operator<<(ostream &os, const DaThuc &dt) {
            if (dt.bacDt >= 0) {
                os << dt.a[dt.bacDt] << "x^" << dt.bacDt; // In hệ số và bậc cao nhất
                for (int i = dt.bacDt - 1; i >= 1; i--) { // Duyệt từ bậc cao đến bậc 1
                    if (dt.a[i] > 0) {
                        os << " + " << dt.a[i] << "x^" << i;
                    } else if (dt.a[i] < 0) {
                        os << " - " << -dt.a[i] << "x^" << i;
                    }
                }
                if (dt.a[0] >= 0) { // Xử lý hệ số bậc 0
                    os << " + " << dt.a[0];
                } else {
                    os << " - " << -dt.a[0];
                }
            } else {
                os << "0"; // Trường hợp đa thức rỗng hoặc hệ số bằng 0
            }
            return os;
        }

        DaThuc operator + ( DaThuc x){
            DaThuc sum;
            sum.bacDt = max(bacDt , x.bacDt);
            for(int i = 0; i <= sum.bacDt; i++){
                sum.a[i] = a[i] + x.a[i];
            }
            return sum;
        }

        DaThuc operator -(DaThuc x){
            DaThuc minus;
            minus.bacDt = max(bacDt , x.bacDt);
            for (int i = 0; i <= minus.bacDt; i++) {
                minus.a[i] = a[i] - x.a[i];
            }
            return minus;   
        }

};
int main(){
    DaThuc dt1, dt2;


    cout << "Nhap da thuc thu nhat:";
    cin >> dt1;
    cout << "Nhap da thuc thu hai:";
    cin >> dt2;
    DaThuc sum = dt1 + dt2;
    cout << "Da thuc thu nhat: " << dt1 << endl;
    cout << "Da thuc thu hai: " << dt2 << endl;

    
    cout << "Tong hai da thuc: " << sum << endl;

    DaThuc minus = dt1 - dt2;
    cout << "Hieu hai da thuc: " << minus << endl;

    return 0;

}
