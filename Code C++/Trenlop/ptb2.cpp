#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

void giaiPhuongTrinhBacHai(double a, double b, double c) {
    // bx + c = 0
    if (a == 0) {
        if (b == 0) {
            if (c == 0) {
                cout << "Phuong trinh co vo so nghiem." << endl;
            } else {
                cout << "Phuong trinh vo nghiem." << endl;
            }
        } else {
            cout << "Phuong trinh co mot nghiem: x = " << -c / b << endl;
        }
        return;
    }
 
    double delta = b * b - 4 * a * c;

    cout << fixed << setprecision(2);  

    if (delta > 0) {
        double x1 = (-b + sqrt(delta)) / (2 * a);
        double x2 = (-b - sqrt(delta)) / (2 * a);
        cout << "Phuong trinh co 2 nghiem phan biet:" << endl;
        cout << "x1 = " << x1 << endl;
        cout << "x2 = " << x2 << endl;
    } else if (delta == 0) {
        double x = -b / (2 * a);
        cout << "Phuong trinh co nghiem kep: x1 = x2 = " << x << endl;
    } else {
        cout << "Phuong trinh vo nghiem thuc." << endl;
    }
}

int main() {
    double a, b, c;

    cout << "--- Giai phuong trinh bac hai ax^2 + bx + c = 0 ---" << endl;
    cout << "Nhap he so a: ";
    cin >> a;
    cout << "Nhap he so b: ";
    cin >> b;
    cout << "Nhap he so c: ";
    cin >> c;

    giaiPhuongTrinhBacHai(a, b, c);

    return 0;
}
