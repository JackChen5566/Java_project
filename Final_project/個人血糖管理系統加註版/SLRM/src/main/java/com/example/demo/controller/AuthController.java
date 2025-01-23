package com.example.demo.controller;

// 引入必要的包和類
import com.example.demo.dto.RegistrationDto;
import com.example.demo.entity.BloodSugar;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.service.MessageService;
import com.example.demo.service.RecordService;
import com.example.demo.service.UserService;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // 表明這是一個控制器類
public class AuthController {

    @Autowired // 自動注入UserService
    private UserService userService;
    
    @Autowired // 自動注入MessageService
    private MessageService messageService;

    @Autowired // 自動注入RecordService
    private RecordService recordService;

    @PostMapping("/messages") // 處理POST請求，發佈消息
    public String postMessage(@AuthenticationPrincipal UserDetails userDetails, @RequestParam String content) {
        messageService.saveMessage(userDetails.getUsername(), content); // 保存消息
        return "redirect:/messages"; // 重定向到/messages以顯示留言板
    }

    @GetMapping("/login") // 處理GET請求，返回登錄頁面
    public String login() {
        return "login";
    }

    @GetMapping("/register") // 處理GET請求，返回註冊頁面
    public String register(Model model) {
        model.addAttribute("user", new RegistrationDto()); // 添加一個新的RegistrationDto到模型
        return "register";
    }

    @PostMapping("/register") // 處理POST請求，註冊新用戶
    public String registerUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(registrationDto.getPassword());
        user.setEmail(registrationDto.getEmail());
        user.setMedicalNumber(registrationDto.getMedicalNumber());  // 設置醫療號碼
        user.setPhone(registrationDto.getPhone());  // 設置電話號碼
        userService.saveUser(user); // 保存用戶
        return "redirect:/login"; // 重定向到登錄頁面
    }

    @GetMapping("/") // 處理GET請求，返回主頁
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        return "home";
    }

    @GetMapping("/home") // 處理GET請求，返回home頁面
    public String homePage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        // 如果需要，可以添加一些邏輯來顯示home頁面的內容
        return "home";
    }

    @GetMapping("/messages") // 處理GET請求，返回消息板頁面
    public String getMessageBoard(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<Message> messages = messageService.getAllMessages();
        if (messages == null) {
            messages = new ArrayList<>(); // 如果消息為空，創建新的消息列表
        }
        Collections.reverse(messages); // 反轉消息列表，使最新的消息顯示在前面
        model.addAttribute("messages", messages);
        model.addAttribute("isAdmin", userDetails != null && userDetails.getUsername().equals("admin99")); // 添加isAdmin標誌
        return "Message"; // 確保你的留言板頁面模板名為 Message.html
    }

    @PostMapping("/messages/delete") // 處理POST請求，刪除消息
    public String deleteMessage(@RequestParam Long id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null && userDetails.getUsername().equals("admin99")) {
            messageService.deleteMessage(id); // 如果是admin99，刪除消息
        }
        return "redirect:/messages"; // 重定向到/messages以顯示留言板
    }

    @GetMapping("/messages/edit") // 處理GET請求，返回消息編輯頁面
    public String editMessage(@RequestParam Long id, Model model) {
        Message message = messageService.getMessageById(id); // 根據ID獲取消息
        model.addAttribute("message", message);
        return "editMessage"; // 返回編輯消息頁面
    }

    @PostMapping("/messages/update") // 處理POST請求，更新消息
    public String updateMessage(@RequestParam Long id, @RequestParam String content) {
        messageService.updateMessage(id, content); // 更新消息內容
        return "redirect:/messages"; // 重定向到/messages以顯示留言板
    }

    @PostMapping("/records") // 處理POST請求，保存血糖記錄
    public String saveRecord(@RequestParam("date") String date,
                             @RequestParam("time") String time,
                             @RequestParam("value") String value,
                             Model model) {
        BloodSugar bloodSugar = new BloodSugar(date, time, value); // 創建新的BloodSugar實體
        recordService.saveRecord(bloodSugar); // 保存血糖記錄
        return "success"; // 返回成功頁面
    }

    @GetMapping("/results") // 處理GET請求，返回結果頁面
    public String getResults(@RequestParam(value = "startDate", required = false) String startDate,
                             @RequestParam(value = "endDate", required = false) String endDate,
                             Model model) {
        if (startDate == null || endDate == null) {
            // 設置默認值
            startDate = "2023-01-01";
            endDate = "2023-12-31";
        }
        List<BloodSugar> results = recordService.findRecordsByDateRange(startDate, endDate); // 查找指定日期範圍內的記錄
        model.addAttribute("results", results); 
        return "results"; // 返回結果頁面
    }

    @GetMapping("/search") // 處理GET請求，返回搜索頁面
    public String search() {
        return "search";
    }

    @GetMapping("/edit") // 處理GET請求，返回編輯頁面
    public String edit() {
        return "edit";
    }

    @PostMapping("/edit") // 處理POST請求，編輯記錄
    public String editRecord(@RequestBody BloodSugar bloodSugar) {
        recordService.updateRecord(bloodSugar); // 更新記錄
        return "redirect:/success";
    }

    @GetMapping("/success") // 處理GET請求，返回成功頁面
    public String success() {
        return "success";
    }

    @PostMapping("/success") // 處理POST請求，返回成功頁面
    public String handleSuccessPost() {
        // 處理邏輯
        return "success"; // 返回成功頁面
    }

    @PostConstruct // 初始化方法，在類加載後執行
    public void init() {
        if (userService.findByUsername("admin99") == null) {
            User admin = new User(); // 創建admin用戶
            admin.setUsername("admin99");
            admin.setPassword("admin99");
            admin.setEmail("admin@demo.com");
            admin.setRole("ADMIN");
            userService.saveUser(admin); // 保存admin用戶
        }
    }

    @GetMapping("/editdata") // 處理GET請求，返回編輯數據頁面
    public String editRecord(@RequestParam Long recordId, Model model) {
        BloodSugar record = recordService.getRecordById(recordId); // 根據ID獲取記錄
        model.addAttribute("record", record);
        return "editdata"; // 返回editdata頁面
    }

    @PostMapping("/records/update") // 處理POST請求，更新記錄
    public String updateRecord(@RequestParam Long recordId, @RequestParam String value) {
        recordService.updateRecordById(recordId, value); // 根據ID更新記錄
        return "redirect:/success"; // 重定向到/success
    }
}
