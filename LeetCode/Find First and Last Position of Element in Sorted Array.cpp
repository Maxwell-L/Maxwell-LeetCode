#include <iostream>
#include <vector>

using namespace std;
vector<int> searchRange(vector<int>& nums, int target);

int main()
{
    int num[] = {0, 0, 0, 1, 2, 3};
    vector<int> nums(num, num+6);
    int target = 0;
    vector<int> ans = searchRange(nums, target);
    cout << ans[0] << "," << ans[1] << endl;
    return 0;
}

vector<int> searchRange(vector<int>& nums, int target) {
    vector<int> ans(2, -1);
    if(nums.empty()){
        return ans;
    }
    int left = 0, right = nums.size() - 1;
    int mid = (left + right) / 2;
    while(left <= right){
        if(nums[mid] == target){
            int l = mid, r = mid;
            while(l >= 0 && nums[l] == target){
                l--;
            }
            while(r <= (int)nums.size() - 1 && nums[r] == target){
                r++;
            }
            ans[0] = ++l;
            ans[1] = --r;
            return ans;
        }
        if(nums[mid] < target){
            left = mid + 1;
            mid = (left + right) / 2;
        }
        else if(nums[mid] > target){
            right = mid - 1;
            mid = (left + right) / 2;
        }
    }
    return ans;
}
