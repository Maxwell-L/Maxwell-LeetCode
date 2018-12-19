#include <iostream>
#include <vector>

using namespace std;

int min(int a, int b);
int maxArea(vector<int>& height);

int main()
{
    int n[] = {1,3,2,5,25,24,5};
    vector<int> v(n, n+7);
    cout << maxArea(v) << endl;
    return 0;
}

int min(int a, int b) {
    return a > b ? b : a;
}
int maxArea(vector<int>& height) {
    int maxarea = 0;
    int i = 0, j = height.size()-1;
    while(i != j){
        int tempArea = (j-i) * min(height[i], height[j]);
        if(tempArea > maxarea){
            maxarea = tempArea;
        }
        if(height[i] > height[j]){
            j--;
        }
        else{
            i++;
        }
    }
    return maxarea;
}
