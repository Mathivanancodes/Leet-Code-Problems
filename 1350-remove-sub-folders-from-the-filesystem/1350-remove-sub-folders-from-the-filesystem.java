class Solution {

    public List<String> removeSubfolders(String[] folder) {
        // Create a set to store all folder paths for fast lookup
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();

        // Iterate through each folder to check if it's a sub-folder
        for (String f : folder) {
            boolean isSubFolder = false;
            String prefix = f;

            // Check all prefixes of the current folder path
            while (!prefix.isEmpty()) {
                int pos = prefix.lastIndexOf('/');
                if (pos == -1) break;

                // Reduce the prefix to its parent folder
                prefix = prefix.substring(0, pos);

                // If the parent folder exists in the set, mark as sub-folder
                if (folderSet.contains(prefix)) {
                    isSubFolder = true;
                    break;
                }
            }

            // If not a sub-folder, add it to the result
            if (!isSubFolder) {
                result.add(f);
            }
        }

        return result;
    }
}