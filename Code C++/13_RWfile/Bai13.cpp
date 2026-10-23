#include <bits/stdc++.h>
using namespace std;
class CanBo{
	protected:
		string macb, madv, hoten;
		int namsinh;
	public:
		void nhap(ifstream &ifs){
			string line;
			getline(ifs, line);
			stringstream ss(line);
			getline(ss, macb, ',');
			getline(ss, madv, ',');
			getline(ss,hoten, ',');
			ss >> namsinh;
		}
		void in(ofstream &ofs){
			ofs << "Ma cb: " << macb << endl;
			ofs << "Ma dv: " << madv << endl;
			ofs << "ho ten: " << hoten << endl;
			ofs << "Nam sinh: " << namsinh << endl;
		}
};
class Luong : public CanBo{
	protected:
		float phucap, hesl, baohiem;
	public:
		void nhap(ifstream &ifs){
			CanBo::nhap(ifs);
			string line;
			getline(ifs, line);
			stringstream ss(line);
			ss>>phucap;
			ss>>hesl;
			ss>>baohiem;
		}
		void in(ofstream &ofs){
			CanBo::in(ofs);
			ofs << "phu cap: " << phucap << endl;
			ofs << "he so luong : " << hesl << endl;
			ofs << "bao hiem: " << baohiem << endl;
		}
		double tinhluong(ofstream &ofs){
			return hesl *290000 + phucap - baohiem;
		}
		
};
int main(){
	
	ifstream ifs("input.txt");
	ofstream ofs("output.txt");
	int n;
	ifs >> n;
	ifs.ignore();
	Luong a[n];
	for (int i = 0; i < n; i++) {
        a[i].nhap(ifs);
    }
    
    for (int i = 0; i < n; i++) {
        a[i].in(ofs);
        cout<< a[i].tinhluong(ofs);
    }
    ifs.close();
    ofs.close();
}
