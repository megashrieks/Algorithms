#include <stdio.h>
#define MAX 60
int data[MAX], temp[MAX];
int parity_bits(int k, int r)
{
	int n, i, j;
	int err_sum = 0, cnt_ones;
	n = 1;
	while (n < (1 << r))
	{
		i = n;
		cnt_ones = 0;
		while (i <= (k + r))
		{
			for (j = 0; j < n; j++)
				if (temp[i + j] == 1)
					cnt_ones++;
			i += n << 1;
		}
		if (cnt_ones & 1)
		{
			temp[n] = 1;
			err_sum += n;
		}
		else
			temp[n] = 0;
		n <<= 1;
	}
	return err_sum;
}

int hamming_code(int k)
{
	int i, j = 1, r = 1, d = 0;
	while (k > ((1 << r) - r - 1))
		++r;
	for (i = 1; i <= (k + r); ++i)
	{
		if (i == (1 << d))
		{
			temp[i] = 0;
			d++;
		}
		else
			temp[i] = data[j++];
	}
	return r;
}

int check_err(int err_pos, int r)
{
	for (int i = 1; i < 1 << r; i <<= 1)
		if (err_pos == i)
			return 1;
	return 0;
}
void main()
{
	int i, k, r, err_pos;
	printf("No of databits : ");
	scanf("%d", &k);
	printf("Enter the data to be transmitted\n");
	for (i = 1; i <= k; ++i)
		scanf("%d", &data[i]);
	r = hamming_code(k);
	printf("No of parity bits r = %d\n", r);
	parity_bits(k, r);
	printf("Hamming code for the data : ");
	for (i = 1; i <= (k + r); ++i)
		printf("%4d", temp[i]);
	printf("\nEnter the received data : ");
	for (i = 1; i <= k + r; ++i)
		scanf("%d", &temp[i]);
	err_pos = parity_bits(k, r);
	if (err_pos != 0)
	{
		if (check_err(err_pos, r))
			printf("\nParity bit %d is corrupted, data is fine", err_pos);
		else
		{
			printf("\nData bit %d is corrupted", err_pos);
			temp[err_pos] = !temp[err_pos];
			printf("\nCorrected data bits with new parity bit\n");
			for (i - 1; i <= (k + r); ++i)
				printf("%4d", temp[i]);
		}
	}
	else
		printf("No error");
}