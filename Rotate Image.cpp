#include <iostream>
#include <vector>

using namespace std;
void rotate(vector<vector<int> >& matrix);

int main()
{
    int nums[3][3] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    vector<vector<int> > matrix;
    vector<int> row1(nums[0], nums[0] + 3);
    matrix.push_back(row1);
    vector<int> row2(nums[1], nums[1] + 3);
    matrix.push_back(row2);
    vector<int> row3(nums[2], nums[2] + 3);
    matrix.push_back(row3);
    for(int i = 0; i < 3; i++){
        cout << matrix[i][0] << " " << matrix[i][1] << " " << matrix[i][2] << endl;
    }
    cout << "rotate:" << endl;
    rotate(matrix);
    for(int i = 0; i < 3; i++){
        cout << matrix[i][0] << " " << matrix[i][1] << " " << matrix[i][2] << endl;
    }
    return 0;
}

void rotate(vector<vector<int> >& matrix) {
    int n = matrix.size();
    int rotate[n][n] = {0};
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            rotate[j][n-i-1] = matrix[i][j];
        }
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            matrix[i][j] = rotate[i][j];
        }
    }
}
