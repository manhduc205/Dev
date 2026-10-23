#include <iostream>
using namespace std;
int main(){
	char a;
	int count = 0;
	while(cin >> a && a != '#'){
		if(a != 'u' && a != 'e' && a != 'o' && a != 'a' && a != 'i'){
			count ++;
		}
	}
	cout << count << endl;
	return 0;
}
