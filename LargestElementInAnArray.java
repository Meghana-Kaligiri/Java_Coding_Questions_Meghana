 “find largest element by sorting the array,” that *works*, but it’s not the smartest brute-force approach. Sorting is extra work when you only need one value.

### ✅ 1. Brute-force (Simple scan — best approach)

Just loop through the array and keep track of the maximum.
 
int findLargest(int[] arr) {
    int max = arr[0];
    
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    
    return max;
}
```

👉 Time Complexity: **O(n)**
👉 This is actually optimal (you can't do better than this)

---

### ❌ 2. Brute-force using sorting (what you mentioned)

You sort the array and pick the last element.

```java
import java.util.Arrays;

int findLargest(int[] arr) {
    Arrays.sort(arr);
    return arr[arr.length - 1];
}
```

👉 Time Complexity: **O(n log n)**
👉 Works, but inefficient for just finding max

---

### ⚡ Key Insight

* Sorting = unnecessary work
* Scanning once = fastest + simplest

---

### 🧠 Interview Tip

If you say:

> “I’ll sort and take last element”

Interviewer will expect you to improve it to:

> “Better approach is single pass O(n)”

---

 Here’s the clean **one-liner using Java Streams**:

```java
int max = java.util.Arrays.stream(arr).max().getAsInt();
```

### 🔍 How it works

* `Arrays.stream(arr)` → converts array to stream
* `.max()` → finds maximum (returns OptionalInt)
* `.getAsInt()` → extracts the value

---

### ⚠️ Important (edge case)

If the array *might be empty*, this can throw an error. Safer version:

 
int max = java.util.Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
 

---

### 🧠 Pro Tip (for interviews)

You can say:

> “Using streams, we can do it in one line, but internally it's still O(n), same as loop — just more expressive.”

 
