from django.db import models
from django.forms import ModelForm

# Create your models here.
class ldb_client(models.Model):
    client_id = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    address_1 = models.CharField(max_length=200)
    address_2 = models.CharField(max_length=200)
    city = models.CharField(max_length=200)
    state = models.CharField(max_length=200)
    zip = models.CharField(max_length=10)
    phone_1 = models.CharField(max_length=14)
    #email = models.EmailField()
    email = models.CharField(max_length=200)
    #date_of_birth = models.DateField()
    date_of_birth = models.CharField(max_length=200)
    ss_num = models.CharField(max_length=11)
    accident_date = models.CharField(max_length=50)
    location = models.CharField(max_length=200)
    injury = models.CharField(max_length=2000)
    #date_signed_up = models.DateField()
    #date_filed = models.DateField()
    date_signed_up = models.CharField(max_length=200)
    date_filed = models.CharField(max_length=200)
    statute_of_limit_date = models.CharField(max_length=50)
    referral_source = models.CharField(max_length=200)

class ldb_client_new_form(ModelForm):
    class Meta:
        model = ldb_client
        fields = '__all__'

class ldb_employer(models.Model):
    emp_id = models.AutoField(primary_key=True)
    employer_name = models.CharField(max_length=100) 
    address_1 = models.CharField(max_length=100)
    address_2 = models.CharField(max_length=100)
    city = models.CharField(max_length=200)
    state = models.CharField(max_length=200)
    zip = models.CharField(max_length=10)
    avg_wkly_wg_ttd_rate = models.IntegerField()
    avg_wkly_wg_ppd_rate = models.IntegerField()
    position = models.CharField(max_length=100)
    start_date = models.CharField(max_length=100)
    end_date = models.CharField(max_length=100)
    contact_name = models.CharField(max_length=200)
    contact_phone = models.CharField(max_length=14)
    #contact_email = models.EmailField()
    contact_email = models.CharField(max_length=200)

class ldb_employer_new_form(ModelForm):
    class Meta:
        model = ldb_employer
        fields = '__all__'

class ldb_insurance(models.Model):
    ins_co_id = models.AutoField(primary_key=True)
    ins_co_name = models.CharField(max_length=100)
    adj_first_name = models.CharField(max_length=100)
    adj_last_name = models.CharField(max_length=100)
    address_1 = models.CharField(max_length=200)
    address_2 = models.CharField(max_length=200)
    city = models.CharField(max_length=200)
    state = models.CharField(max_length=200)
    zip = models.CharField(max_length=10)
    phone_1 = models.CharField(max_length=14)
    phone_2 = models.CharField(max_length=14)
    fax = models.CharField(max_length=14)
    #email = models.EmailField()
    email = models.CharField(max_length=200)
    claim_number = models.CharField(max_length=200) 

class ldb_insurance_new_form(ModelForm):
    class Meta:
        model = ldb_insurance
        fields = '__all__'

class ldb_opp_coun(models.Model):
    opp_coun_id = models.AutoField(primary_key=True)
    firm_name = models.CharField(max_length=100)
    att_first_name = models.CharField(max_length=100)
    att_last_name = models.CharField(max_length=100)
    address_1 = models.CharField(max_length=200)
    address_2 = models.CharField(max_length=200)
    city = models.CharField(max_length=200)
    state = models.CharField(max_length=200)
    zip = models.CharField(max_length=10)
    phone_1 = models.CharField(max_length=14)
    phone_2 = models.CharField(max_length=14)
    fax = models.CharField(max_length=14)
    #email = models.EmailField()
    email = models.CharField(max_length=200)

class ldb_opp_coun_new_form(ModelForm):
    class Meta:
        model = ldb_opp_coun
        fields = '__all__'

class ldb_lien(models.Model):
    lien_id = models.AutoField(primary_key=True)
    lien_name = models.CharField(max_length=100)
    lien_amt = models.CharField(max_length=100)

class ldb_lien_new_form(ModelForm):
    class Meta:
        model = ldb_lien
        fields = '__all__'

class ldb_case(models.Model):
    case_id = models.AutoField(primary_key=True)
    file_number = models.CharField(max_length=100)
    fee_petition_name = models.CharField(max_length=100)
    fee_petition_amt = models.CharField(max_length=100)
    ldb_client = models.ForeignKey(ldb_client, on_delete=models.CASCADE)
    ldb_employer = models.ForeignKey(ldb_employer, on_delete=models.CASCADE)
    ldb_insurance = models.ForeignKey(ldb_insurance, on_delete=models.CASCADE)
    ldb_opp_coun = models.ForeignKey(ldb_opp_coun, on_delete=models.CASCADE)
    ldb_lien = models.ForeignKey(ldb_lien, on_delete=models.CASCADE)

class ldb_case_new_form(ModelForm):
    class Meta:
        model = ldb_case
        fields = '__all__'
