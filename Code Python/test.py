import math

x=int(input('nhập x: '))
y=int(input('nhập y: '))
N=int(input('nhập số N: '))
while x>y or y>N or x>N:
    x=int(input('nhập lại x (x<y): '))
    y=int(input('nhập lại y (y<N): '))
    N=int(input('nhập độ dài đoạn A: '))
def so(n):
    if n<=1:
        return False 
    for i in range(2,int(math.sqrt(n)) + 1):
        if n%i==0:
            return False
    return True
A=[int(i) for i in input(f'Nhập {N+1} số cách nhau bởi dấu cách: ').split()] 
B=[]
for a in A:
    if int(A[x])<=a<=int(A[y]):
        if so(a):
            B.append(a)
for b in B:
    print(b,end=' ')            
if B==[]:
    print('NO')