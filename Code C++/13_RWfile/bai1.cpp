#include <iostream>
#include <vector>
#include <fstream>
#include <string>
using namespace std;
int main(){
    ifstream in;
    ofstream out;
    out.open("output.txt", ios::out);
    in.open("input.txt", ios::in);

    vector<string> res;
    string s;
    while(getline(in, s)){
        res.push_back(s);
    }
    for(string x : res){
        cout << x << endl;
        out << x << endl;
    }
    out.close();
    in.close();
}