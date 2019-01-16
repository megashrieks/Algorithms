#include <iostream>

using namespace std;

int CRC16 = (1 << 16) |
			(1 << 12) |
			(1 << 5) |
			1;
int CRC3 = (1 << 3) |
		   (1 << 1) |
		   1;
int CRC = CRC16;
int cycles = 17;
typedef long long ll;

void read(ll &input)
{
	int n;
	cout << "Enter the no of bits you want to set : ";
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		int temp;
		cout << "Enter the bit you want to set : ";
		cin >> temp;
		input = input | (1 << temp);
	}
}
bool get_bit(ll source, int bit_index)
{
	return (source >> bit_index) & 1;
}
void set_bit(ll &source, int bit_index, bool value)
{
	if (value)
		source = source | (1 << bit_index);
	else
	{
		if ((source >> bit_index) & 1)
			source = source ^ (1 << bit_index);
	}
}

ll reverse_bits(ll source)
{
	ll reverse = 0;
	while (source != 0)
	{
		reverse = reverse << 1;
		if (source & 1)
			++reverse;
		source = source >> 1;
	}
	return reverse;
}

void operate(ll source)
{
	ll input = reverse_bits(source);
	int CRCR = reverse_bits(CRC);
	ll result = 0;
	ll previous_result;
	int previous_bit = 0;
	int feedback = 0;
	int cycle_counter = cycles * 2 - 1;

	while (cycle_counter--)
	{
		previous_result = result;
		previous_bit = input & 1;
		input = input >> 1;
		feedback = get_bit(result, 0);
		for (int i = cycles - 1; i >= 0; --i)
		{
			set_bit(result, i - 1, (feedback & get_bit(CRCR, i)) ^ previous_bit);
			previous_bit = get_bit(previous_result, i - 1);
		}
	}
	for (int i = cycles - 2; i >= 0; --i)
		cout << get_bit(result, i);
	cout << endl;
}
int main()
{
	ll input = 0;
	read(input);
	input = input << (cycles - 1);
	operate(input);
	return 0;
}