from django.shortcuts import render
from django.template import Context, loader
from django.http import HttpResponse, Http404
from lawyer_proj.lawyer_app.models import ldb_client, ldb_employer, \
     ldb_insurance, ldb_opp_coun, ldb_lien, ldb_case, \
     ldb_client_new_form, ldb_employer_new_form, \
     ldb_insurance_new_form, ldb_opp_coun_new_form, ldb_lien_new_form

# Create your views here.
def index(request):
    #people_list = cx_people.objects.all()
    templ = loader.get_template("index.html")
    #cont = Context({'cx_people': people_list})
    #return HttpResponse(templ.render(cont))
    return HttpResponse(templ.render())

def ldb_client_new(request):
    if request.POST:
        form = ldb_client_new_form(request.POST)
        if form.is_valid():
            form.save()
    else:
        form = ldb_client_new_form()
    return render(request, 'client_new.html')

def ldb_employer_new(request):
    if request.POST:
        form = ldb_employer_new_form(request.POST)
        if form.is_valid():
            form.save()
        else:
            raise Http404("Form issues?")
    else:
        form = ldb_employer_new_form()
    return render(request, 'employer_new.html')

def ldb_lien_new(request):
    if request.POST:
        form = ldb_lien_new_form(request.POST)
        if form.is_valid():
            form.save()
        else:
            raise Http404("Form issues?")
    else:
        form = ldb_lien_new_form()
    return render(request, 'lien_new.html')

def ldb_insurance_new(request):
    if request.POST:
        form = ldb_insurance_new_form(request.POST)
        if form.is_valid():
            form.save()
        else:
            raise Http404("Form issues?")
    else:
        form = ldb_insurance_new_form()
    return render(request, 'insurance_new.html')

def ldb_opp_coun_new(request):
    if request.POST:
        form = ldb_opp_coun_new_form(request.POST)
        if form.is_valid():
            form.save()
    else:
        form = ldb_opp_coun_new_form()
    return render(request, 'opp_coun_new.html')

def ldb_employer_view(request):
    employer_list = ldb_employer.objects.all()
    templ = loader.get_template("employers.html")
    cont = Context({'ldb_employers': employer_list})
    return HttpResponse(templ.render(cont))

def ldb_lien_view(request):
    lien_list = ldb_lien.objects.all()
    templ = loader.get_template("liens.html")
    cont = Context({'ldb_liens': lien_list})
    return HttpResponse(templ.render(cont))

def ldb_insurance_view(request):
    insurance_list = ldb_insurance.objects.all()
    templ = loader.get_template("insurance.html")
    cont = Context({'ldb_insurance': insurance_list})
    return HttpResponse(templ.render(cont))

def ldb_client_view(request):
    client_list = ldb_client.objects.all()
    templ = loader.get_template("clients.html")
    cont = Context({'ldb_client': client_list})
    return HttpResponse(templ.render(cont))

def ldb_opp_coun_view(request):
    opp_coun_list = ldb_opp_coun.objects.all()
    templ = loader.get_template("opp_coun.html")
    cont = Context({'ldb_opp_coun': opp_coun_list})
    return HttpResponse(templ.render(cont))

# this one works
def ldb_client_details(request, id):
    try:
        client = ldb_client.objects.get(pk=id)
    except ldb_client.DoesNotExist:
        raise Http404("Client does not exist")
    return render(request, 'client_details.html', {'client': client })

def ldb_client_edit(request, id):
    try:
        client = ldb_client.objects.get(pk=id)
        client.first_name = request.POST['first_name']
        client.last_name = request.POST['last_name']
        client.address_1 = request.POST['address_1']
        client.address_2 = request.POST['address_2']
        client.city = request.POST['city']
        client.state = request.POST['state']
        client.zip = request.POST['zip']   
        client.phone_1 = request.POST['phone_1']
        client.email = request.POST['email']
        client.date_of_birth = request.POST['date_of_birth']
        client.ss_num = request.POST['ss_num']
        client.accident_date = request.POST['accident_date']
        client.location = request.POST['location']
        client.injury = request.POST['injury']
        client.date_signed_up = request.POST['date_signed_up']
        client.date_filed = request.POST['date_filed']
        client.statue_of_limit_date = request.POST['statute_of_limit_date']
        client.referral_source = request.POST['referral_source']
    except ldb_client.DoesNotExist:
        raise Http404("Client does not exist")
    else:
        client.save()
        return render(request, 'client_details.html', {'client': client })


# this one works
def ldb_insurance_details(request, id):
    try:
        insurance = ldb_insurance.objects.get(pk=id)
    except ldb_insurance.DoesNotExist:
        raise Http404("Insurance does not exist")
    return render(request, 'insurance_details.html', {'insurance': insurance })

def ldb_insurance_edit(request, id):
    try:
        insurance = ldb_insurance.objects.get(pk=id)
        insurance.ins_co_name = request.POST['ins_co_name']
        insurance.adj_first_name = request.POST['adj_first_name']
        insurance.adj_last_name = request.POST['adj_last_name']
        insurance.address_1 = request.POST['address_1']
        insurance.address_2 = request.POST['address_2']
        insurance.city = request.POST['city']
        insurance.state = request.POST['state']
        insurance.zip = request.POST['zip']   
        insurance.phone_1 = request.POST['phone_1']
        insurance.phone_2 = request.POST['phone_2']
        insurance.fax = request.POST['fax']
        insurance.email = request.POST['email']
        insurance.claim_number = request.POST['claim_number']
    except ldb_insurance.DoesNotExist:
        raise Http404("Insurance does not exist")
    else:
        insurance.save()
        return render(request, 'insurance_details.html', {'insurance': insurance })



# this one works
def ldb_opp_coun_details(request, id):
    try:
        opp_coun = ldb_opp_coun.objects.get(pk=id)
    except ldb_opp_coun.DoesNotExist:
        raise Http404("Opposing Counsel does not exist")
    return render(request, 'opp_coun_details.html', {'opp_coun': opp_coun })

def ldb_opp_coun_edit(request, id):
    try:
        opp_coun = ldb_opp_coun.objects.get(pk=id)
        opp_coun.firm_name = request.POST['firm_name']
        opp_coun.att_first_name = request.POST['att_first_name']
        opp_coun.att_last_name = request.POST['att_last_name']
        opp_coun.address_1 = request.POST['address_1']
        opp_coun.address_2 = request.POST['address_2']
        opp_coun.city = request.POST['city']
        opp_coun.state = request.POST['state']
        opp_coun.zip = request.POST['zip']   
        opp_coun.phone_1 = request.POST['phone_1']
        opp_coun.phone_2 = request.POST['phone_2']
        opp_coun.fax = request.POST['fax']
        opp_coun.email = request.POST['email']
    except ldb_opp_coun.DoesNotExist:
        raise Http404("Opposing Counsel does not exist")
    else:
        opp_coun.save()
        return render(request, 'opp_coun_details.html', {'opp_coun': opp_coun })



# this one works
def ldb_employer_details(request, id):
    try:
        employer = ldb_employer.objects.get(pk=id)
    except ldb_employer.DoesNotExist:
        raise Http404("Employer does not exist")
    return render(request, 'employer_details.html', {'employer': employer })

def ldb_employer_edit(request, id):
    try:
        employer = ldb_employer.objects.get(pk=id)
        employer.employer_name = request.POST['employer_name']
        employer.address_1 = request.POST['address_1']
        employer.address_2 = request.POST['address_2']
        employer.city = request.POST['city']
        employer.state = request.POST['state']
        employer.zip = request.POST['zip']   
        employer.avg_wkly_wg_ttd_rate = request.POST['avg_wkly_wg_ttd_rate']
        employer.avg_wkly_wg_ppd_rate = request.POST['avg_wkly_wg_ppd_rate']
        employer.position = request.POST['position']
        employer.start_date = request.POST['start_date']
        employer.contact_name = request.POST['contact_name']
        employer.contact_phone = request.POST['contact_phone']
        employer.contact_email = request.POST['contact_email']        
    except ldb_employer.DoesNotExist:
        raise Http404("Employer does not exist")
    else:
        employer.save()
        return render(request, 'employer_details.html', {'employer': employer })



# this one works
def ldb_lien_details(request, id):
    try:
        lien = ldb_lien.objects.get(pk=id)
    except ldb_lien.DoesNotExist:
        raise Http404("Lien does not exist")
    return render(request, 'lien_details.html', {'lien': lien })

def ldb_lien_edit(request, id):
    try:
        lien = ldb_lien.objects.get(pk=id)
        lien.lien_name = request.POST['lien_name']
        lien.lien_amt = request.POST['lien_amt']
    except ldb_lien.DoesNotExist:
        raise Http404("Lien does not exist")
    else:
        lien.save()
        return render(request, 'lien_details.html', {'lien': lien })
