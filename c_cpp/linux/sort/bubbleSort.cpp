#include <iostream>

using namespace std;

int main(int argc, char *argv[])
{
	//cout << argc; return 0;

	int a[] = {3,5,1,2,5};
	int n = sizeof(a)/sizeof(*a);

	//sorting
	for(int i=0; i<n-1; i++){
		for(int j=i+1; j<n; j++){
			if(a[i]>a[j]){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}
	
	for(int i=0; i<n; i++){
		cout << a[i] << endl;
	}
	return 0;
}
