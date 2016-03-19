using namespace std;

int findMaxSum(int *arr, int n)
{
  int incl = arr[0];
  int excl = 0;
  int excl_new;
  int i;
 
  for (i = 1; i < n; i++)
  {
    excl_new = (incl > excl)? incl: excl;
    incl = excl + arr[i];
    excl = excl_new;
  }
  return max(incl,excl);
  
}

int main()
{
  int arr[4] = {1,2,3,4};
  cout<<findMaxSum(arr,4)<<endl;
}
