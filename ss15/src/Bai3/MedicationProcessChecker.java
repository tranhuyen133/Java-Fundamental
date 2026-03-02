package Bai3;

import java.util.Stack;

public class MedicationProcessChecker {
    private Stack<String> stack = new Stack<>();
    private String lastError = "";

    /**
     * actions: mảng các thao tác, mỗi phần tử là "PUSH" hoặc "POP"
     * return: true nếu hợp lệ, false nếu không hợp lệ
     */
    public boolean checkProcess(String[] actions) {
        reset();
        if (actions == null) {
            lastError = "Danh sách thao tác = null";
            return false;
        }

        for (int i = 0; i < actions.length; i++) {
            String actRaw = actions[i];
            if (actRaw == null) {
                lastError = "Thao tác ở vị trí " + (i + 1) + " bị null";
                return false;
            }

            String act = actRaw.trim().toUpperCase();

            if ("PUSH".equals(act)) {
                stack.push("MED"); // giá trị tượng trưng
            } else if ("POP".equals(act)) {
                if (stack.isEmpty()) {
                    lastError = "Sai ở bước " + (i + 1) + ": POP khi Stack rỗng (chưa phát thuốc mà đã hoàn tất).";
                    return false;
                }
                stack.pop();
            } else {
                lastError = "Sai ở bước " + (i + 1) + ": thao tác không hợp lệ '" + actRaw + "' (chỉ nhận PUSH/POP).";
                return false;
            }
        }

        if (!stack.isEmpty()) {
            lastError = "Kết thúc ca trực Stack chưa rỗng: còn " + stack.size()
                    + " lần PUSH chưa được POP (chưa hoàn tất phát thuốc).";
            return false;
        }

        lastError = "";
        return true;
    }

    public void reset() {
        stack.clear();
        lastError = "";
    }

    public String getLastError() {
        return lastError;
    }
}