#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    int fd, N;
    char buffer[2048];

    N = atoi(argv[1]);      // số byte cần đọc
    fd = open(argv[2], O_RDONLY);

    lseek(fd, -N, SEEK_END);     // nhảy đến N byte cuối

    int bytes = read(fd, buffer, N);
    buffer[bytes] = '\0';

    printf("%s", buffer);

    close(fd);
    return 0;
}
