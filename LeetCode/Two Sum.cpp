#include <iostream>
#include <vector>

using namespace std;
vector<int> twoSum(vector<int>& nums, int target);

int main()
{
    int arr[] = {2, 7, 11, 15};
    vector<int> nums(arr, arr+4);
    int target = 9;
    vector<int> ans = twoSum(nums, target);
    cout << ans[0] << "," << ans[1] << endl;
    return 0;
}

vector<int> twoSum(vector<int>& nums, int target) {
    for (int i = 0; i < (int)nums.size(); i++) {
        for (int j = i + 1; j < (int)nums.size(); j++) {
            if (nums[j] == target - nums[i]) {
                vector<int> ans(2,0);
                ans[0] = i;
                ans[1] = j;
                return ans;
            }
        }
    }
}
