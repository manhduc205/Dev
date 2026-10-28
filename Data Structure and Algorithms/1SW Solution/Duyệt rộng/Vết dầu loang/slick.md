Đề bài
Một tai nạn hàng hải đã khiến dầu tràn ra biển. Để có được thông tin về mức độ nghiêm trọng của thảm họa này, người ta phải phân tích các hình ảnh chụp từ vệ tinh, từ đó tính toán chi phí khắc phục cho phù hợp. Đối với điều này, số lượng vết dầu loang trên biển và kích thước của mỗi vết loang phải được xác định. Vết loang là một mảng dầu nổi trên mặt nước.

Để tiện cho việc xử lí, hình ảnh được chuyển đổi thành một ma trận nhị phân kích thước 
N
×
M
N×M 
(
1
≤
N
,
M
≤
250
)
(1≤N,M≤250). Với 
1
1 là ô bị nhiễm dầu, và 
0
0 là ô không bị nhiễm dầu. Vết dầu loang là tập hợp của một số ô bị nhiễm dầu có chung cạnh.

Họ đã thuê bạn để giúp họ xử lí hình ảnh. Công việc của bạn là đếm số lượng vết loang trên biển và kích thước tương ứng của từng vết.

Ý tưởng
Ta xây dựng một mô hình đồ thị của bài toán như sau:

Gọi mỗi đỉnh của đồ thị tương ứng với mỗi ô 
1
1 (ô bị nhiễm dầu) của ma trận.
Tồn tại một cạnh nối giữa cặp đỉnh 
(
u
,
v
)
(u,v) khi và chỉ khi ô tương ứng với đỉnh 
u
u kề cạnh với ô tương ứng với đỉnh 
v
v và cả hai ô đều là ô 
1
1.
Khi đó, bài toán quy về thành bài toán xác định thành phần liên thông của đồ thị. Trong đó, mỗi thành phần liên thông tương ứng với mỗi một vết dầu loang.

Nghĩa là, số lượng thành phần liên thông của đồ thị chính là số lượng vết dầu loang. Và số lượng đỉnh nằm trong cùng một thành phần liên thông là kích thước của vết loang tương ứng.

Thuật toán
Áp dụng thuật toán loang trên ma trận để xác định thành phần liên thông:

Khởi tạo số lượng vết dầu bằng 
0
0.
Duyệt dần từng ô của ma trận, nếu ô đang xét là một ô bị nhiễm dầu (ô 
1
1) và chưa được đánh dấu:
Đánh dấu lại ô đó.
Tăng số lượng vết dầu thêm 
1
1.
Thực hiện thủ tục 
BFS
BFS xuất phát từ ô đó để loang ra các ô xung quanh như sau:
Khởi tạo kích thước của vết dầu đang xét là 
1
1.
Tiếp tục thực hiện công việc sau cho đến khi không còn thực hiện được nữa: Từ một ô đã đánh dấu, ta đánh dấu tất cả các ô bị nhiễm dầu kề cạnh với ô đó mà chưa được đánh dấu. Mỗi lần đánh dấu lại một ô thì ta tăng kích thước của vết dầu thêm 
1
1.
Sử dụng 
1
1 mảng để lưu lại kích thước của từng vết loang.
Nếu tất cả các ô bị nhiễm dầu đều đã được đánh dấu, trả ra kết quả và kết thúc thuật toán.