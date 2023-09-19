#include "iostream"
#include "stdio.h"

using namespace std;

class P
{
public:
	int a;
	int c;
	P() {
		this->a = 10;
		this->c = 20;
	}
} p, q;

void change(P *a) {
	//cout<<a;
	// a = q; // not possible
	*a=q;
	a->a=300;
	//a->c=q.c;
}

int main() {
	//P p = new P();
	q.a = 100;
	q.c = 200;
	cout<<p.a<<"-"<<p.c<<"\n";
	change(&p);
	printf("%d-%d\n", p.a, p.c);
 	return 0;
}


