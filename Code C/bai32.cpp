#include <stdio.h>
#include <ctype.h>
#include <string.h>


void clean_string(char str[]) {
    int length = strlen(str);
    char cleaned[length + 1];
    int j = 0;
    for (int i = 0; i < length; i++) {
        if (isalnum(str[i]) || isspace(str[i])) {
            if (!isspace(str[i]) || (i > 0 && !isspace(str[i - 1]))) {
                cleaned[j++] = str[i];
            }
        }
    }
    cleaned[j] = '\0';

    // Loai bo ki tu vo nghia o cuoi cau
    while (j > 0 && isspace(cleaned[j - 1])) {
        cleaned[--j] = '\0';
    }

    // viet hoa chu cai dau cau
    if (j > 0) {
        cleaned[0] = toupper(cleaned[0]);
    }

    // Sao chép k?t qu? vào chuoi dau vao
    strcpy(str, cleaned);
}

void count_words_and_find_longest(char* str) {
    int max_length = 0;
    int word_count = 0;
    char* longest_word = NULL;
    char* token = strtok(str, " ");

    while (token != NULL) {
        int length = strlen(token);
        if (length > max_length) {
            max_length = length;
            longest_word = token;
        }
        word_count++;
        token = strtok(NULL, " ");
    }


    if (longest_word != NULL) {
        printf("Tu có do dài lon nhat: %s\n", longest_word);
    }
}

int main() {
    char input_string[1000];

    printf("Nhap vào mot xâu: ");
    fflush(stdin);
    gets(input_string);

    clean_string(input_string);
    printf("Xâu sau khi xu lý: %s\n", input_string);

    count_words_and_find_longest(input_string);

    return 0;
}

