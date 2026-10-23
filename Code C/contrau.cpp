#include <stdio.h>
#include <math.h>
int main(){
	int trdung;
	int trnam;
	int traugia;
	for(int trdung=1; trdung <=100; trdung++){
		for(int trnam=1; trnam <= 100; trnam++){
			for(int trgia=1; trgia<=100; trgia++){
				if((trdung*15 + trnam*9 + trgia ==300 ) && (trdung+trnam+trgia == 100)){
					printf("Trau dung: %d\n", trdung);
					printf("Trau nam: %d\n", trnam);
					printf("Trau gia: %d\n", trgia);
				}
			}
		}
	}
}
