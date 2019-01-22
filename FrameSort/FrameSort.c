#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#define MSGSIZE 100
typedef struct {
	char message[MSGSIZE];
	int seq_no;
} Frame;
Frame readFrame(int seq_no){
	Frame f;
	f.seq_no = seq_no;
	printf("Enter the message for the frame %d : ",seq_no);
	scanf("\n");
	scanf("%[^\n]s",f.message);
	return f;
}
void shuffleFrames(Frame f[], int n){
	time_t t;
	srand(time(&t));
	for (int i = 0;i < n;++i){
		int pos = rand() % n;
		Frame temp = f[pos];
		f[pos] = f[i];
		f[i] = temp;
	}
}
void display(Frame f[], int n){
	for(int i = 0;i < n;++i)
		printf("Frame %d message : %s\n",i,f[i].message);
}
void displaySorted(Frame f[], int n){
	char messages[n][MSGSIZE];
	for(int i = 0;i < n; ++i)
		strcpy(messages[f[i].seq_no],f[i].message);
	for(int i = 0;i < n;++i)
		printf("frame %d message : %s\n",i,messages[i]);
}
int main(){
	int choice,n,frame_size=5,frame_count=-1;
	Frame frames[50];
	printf("0. Exit\n");
	printf("Dynamic frame sizes : \n\t1. Enter in sorted frame order\n\t2. Enter message and frame no\nFixed frame size : \n\t3. Enter message\n\t4. Enter message and frame no\nEnter choice : ");
	scanf("%d",&choice);
	if (choice == 1){
		printf("Enter the number of frames : ");
		scanf("%d",&n);
		for(int i = 0;i < n;++i){
			frames[i] = readFrame(i);
		}
		shuffleFrames(frames,n);
		printf("----shuffled frames----\n");
		display(frames,n);
		printf("----sorted frames----\n");
		displaySorted(frames,n);
	}else if(choice == 2 || choice == 4){
		printf("Enter the number of frames : ");
		scanf("%d",&n);
		if (choice == 4) printf("Frame size = %d\n",frame_size);
		for(int i = 0;i < n;++i){
			printf("Enter frame number : ");
			int frame_no;
			scanf("%d",&frame_no);
			frames[i] = readFrame(frame_no);
			if (choice == 4)
				frames[i].message[frame_size] = 0;
		}
		printf("----shuffled frames----\n");
		display(frames,n);
		printf("----sorted frames----\n");
		displaySorted(frames,n);
	}else if(choice == 3){
		char message[MSGSIZE*10];
		printf("Frame size = %d\n",frame_size);
		printf("Enter the message to send :");
		scanf("\n");
		scanf("%[^\n]s",message);
		for(int i = 0;message[i];++i){
			if (!(i % frame_size)){
				if(i != 0) frames[frame_count].message[frame_size] = 0;
				frame_count++;
				frames[frame_count].seq_no = frame_count;
			}
			frames[frame_count].message[i%frame_size] = message[i];
		}
		frames[frame_count].message[frame_size] = 0;
		printf("----shuffled frames----\n");
		shuffleFrames(frames,frame_count+1);
		display(frames,frame_count+1);
		printf("----sorted frames----\n");
		displaySorted(frames,frame_count+1);
	}
	return 0;
}
