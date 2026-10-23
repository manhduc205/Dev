#include <stdio.h>
#include <pthread.h>

long long N, tong = 0;
int M;
pthread_mutex_t lock;

int isPrime(long long x) {
    if (x < 2) return 0;
    for (long long i = 2; i * i <= x; i++) {
        if (x % i == 0) return 0;
    }
    return 1;
}

void* run(void* arg) {
    long long id = (long long)arg;

    long long start = id * (N / M) + 1;
    long long end;

    // nếu là luồng cuối thì kết thúc là N
    if (id == M - 1) {
        end = N;
    } else {
        end = (id + 1) * (N / M);
    }

    long long dem = 0;

    for (long long i = start; i <= end; i++) {
        if (isPrime(i)) {
            dem++;
        }
    }

    pthread_mutex_lock(&lock);
    tong += dem;
    pthread_mutex_unlock(&lock);

    return NULL;
}

int main() {
    printf("Nhap N: ");
    scanf("%lld", &N);

    printf("Nhap so luong luong M: ");
    scanf("%d", &M);

    pthread_t t[100];
    pthread_mutex_init(&lock, NULL);

    for (long long i = 0; i < M; i++) {
        pthread_create(&t[i], NULL, run, (void*)i);
    }

    for (int i = 0; i < M; i++) {
        pthread_join(t[i], NULL);
    }

    printf("Tong so nguyen to: %lld\n", tong);
    return 0;
}
