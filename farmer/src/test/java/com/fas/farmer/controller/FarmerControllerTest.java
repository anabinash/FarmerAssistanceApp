package com.fas.farmer.controller;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fas.farmer.dtos.AddComplaintRequest;
import com.fas.farmer.dtos.ChangePasswordRequest;
import com.fas.farmer.dtos.LoginCredentials;
import com.fas.farmer.dtos.UpdateFarmer;
import com.fas.farmer.dtos.User;
import com.fas.farmer.entities.Complaint;
import com.fas.farmer.entities.Farmer;
import com.fas.farmer.service.IFarmersService;

@WebMvcTest(FarmersController.class)
public class FarmerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IFarmersService farmerService;

    @InjectMocks
    private FarmersController farmersController;

    @Test
    void testLogin_Success() throws Exception {
        LoginCredentials loginCredentials = new LoginCredentials();
        User user = new User();
          
        when(farmerService.loginWithCredentials(any(LoginCredentials.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/farmers/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"username\",\"password\":\"password\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("username"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("Farmer"));
                                                                                        
        verify(farmerService, times(1)).loginWithCredentials(any(LoginCredentials.class));
    }
 
    @Test
    void testLogout_Success() throws Exception {
        User user = new User();

        when(farmerService.logout(anyString())).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/farmers/logout/{username}", "username"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("username"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("Farmer"));

        verify(farmerService, times(1)).logout(anyString());
    }

    @Test
    void testChangePassword_Success() throws Exception {
        ChangePasswordRequest request = new ChangePasswordRequest();
        User user = new User();

        when(farmerService.changePassword(any(ChangePasswordRequest.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/farmers/changePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"username\",\"oldPassword\":\"oldPassword\",\"newPassword\":\"newPassword\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("username"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("Farmer"));

        verify(farmerService, times(1)).changePassword(any(ChangePasswordRequest.class));
    }

    @Test
    void testUpdateFarmer_Success() throws Exception {
        UpdateFarmer updateFarmer = new UpdateFarmer();
        Farmer farmer = new Farmer();

        when(farmerService.updateFarmer(any(UpdateFarmer.class))).thenReturn(farmer);

        mockMvc.perform(MockMvcRequestBuilders.post("/farmers/updateFarmer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"username\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"pincode\":\"12345\",\"phnNumber\":\"9876543210\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("username"));

        verify(farmerService, times(1)).updateFarmer(any(UpdateFarmer.class));
    }

    @Test
    void testGetById_Success() throws Exception {
        Farmer farmer = new Farmer();

        when(farmerService.getFarmerById(anyLong())).thenReturn(farmer);

        mockMvc.perform(MockMvcRequestBuilders.get("/farmers/findById/{farmerId}", 1))
                .andExpect(status().isOk());

        verify(farmerService, times(1)).getFarmerById(anyLong());
    }

    @Test
    void testAddComplaint_Success() throws Exception {
        AddComplaintRequest addComplaintRequest = new AddComplaintRequest();
        Complaint complaint = new Complaint();

        when(farmerService.addComplaint(any(AddComplaintRequest.class))).thenReturn(complaint);

        mockMvc.perform(MockMvcRequestBuilders.post("/farmers/raiseComplaint")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"farmerId\":1,\"complaintDescription\":\"Complaint description\"}"))
                .andExpect(status().isOk());

        verify(farmerService, times(1)).addComplaint(any(AddComplaintRequest.class));
    }
}
