#include <iostream>
using namespace std;

void read(int input[100], int n){
	int set_bits;
	cout << "Enter the bits u want to set : ";
	for ( int  i = 0;i < n+16; ++i )
		input[i] = 0;
	for ( int i = 0;i < n;++i ){
		int temp;
		cin >> temp;
		input[temp] = 1;	
	}
}
void show_bits(int input[100], int no_of_bits){
	cout << "The bits are : " << endl;
	for( int i = 0;i < no_of_bits; ++i )
		cout << input[i];
	cout << endl;
}

void compute_crc(int input[100], int no_of_bits){
	int reg[100];
	for ( int i = 0;i <= no_of_bits + 16; ++i )
		reg[i] = 0;
	
	for ( int i = 0;i < no_of_bits + 16;++i ){
		int lmb = reg[15];
		for( int j = 15;j >= 0; --j )
			reg[j] = reg[j-1];
		reg[0] = input[i];
		if ( lmb ) {
			reg[12] = reg[12] ^ lmb;
			reg[5] = reg[5] ^ lmb;
			reg[0] = reg[0] ^ lmb;
		}
	}
	for ( int i = 0;i < 16;++i )
		input[i + no_of_bits] = reg[15 - i];
	show_bits(input, no_of_bits + 16);
}

int main(){
	int n;
	int input[100];
	cout << "Enter the number of bits : ";
	cin >> n;
	read(input, n);
	show_bits(input, n+16);
	cout << "----------Computing CRC----------" << endl;
	compute_crc(input, n);
	compute_crc(input, n);
	return 0;
}
