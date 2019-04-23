from django.conf.urls import url
from lawyer_proj.lawyer_app.views import index, \
     ldb_client_new, ldb_client_view, ldb_client_details, ldb_client_edit, \
     ldb_employer_new, ldb_employer_view, ldb_employer_details, ldb_employer_edit, \
     ldb_insurance_new, ldb_insurance_view, ldb_insurance_details, ldb_insurance_edit, \
     ldb_opp_coun_new, ldb_opp_coun_view, ldb_opp_coun_details, ldb_opp_coun_edit, \
     ldb_lien_new, ldb_lien_view, ldb_lien_details, ldb_lien_edit 
#from lawyer_proj.lawyer_app.models import ldb_client, ldb_client_new_form

urlpatterns = [
url(r'^$', index),
url(r'^clients/$', ldb_client_view),
url(r'^client_new/$', ldb_client_new),
url(r'^client_details/([0-9]+)/$', ldb_client_details),
url(r'^client_edit/([0-9]+)/$', ldb_client_edit),
url(r'^employer_new/$', ldb_employer_new),
url(r'^employers/$', ldb_employer_view),
url(r'^employer_details/([0-9]+)/$', ldb_employer_details),
url(r'^employer_edit/([0-9]+)/$', ldb_employer_edit),
url(r'^insurance_new/$', ldb_insurance_new),
url(r'^insurance/$', ldb_insurance_view),
url(r'^insurance_details/([0-9]+)/$', ldb_insurance_details),
url(r'^insurance_edit/([0-9]+)/$', ldb_insurance_edit),
url(r'^opp_coun_new/$', ldb_opp_coun_new),
url(r'^opp_coun/$', ldb_opp_coun_view),
url(r'^opp_coun_details/([0-9]+)/$', ldb_opp_coun_details),
url(r'^opp_coun_edit/([0-9]+)/$', ldb_opp_coun_edit),
url(r'^liens/$', ldb_lien_view),
url(r'^lien_new/$', ldb_lien_new),
url(r'^lien_details/([0-9]+)/$', ldb_lien_details),
url(r'^lien_edit/([0-9]+)/$', ldb_lien_edit),

]

#http://127.0.0.1:8000/lawyer_app/client_new/
#http://127.0.0.1:8000/lawyer_app/employer_new/
#http://127.0.0.1:8000/lawyer_app/insurance_new/
#http://127.0.0.1:8000/lawyer_app/opp_coun_new/
#http://127.0.0.1:8000/lawyer_app/lien_new/

#http://127.0.0.1:8000/lawyer_app/clients/
#http://127.0.0.1:8000/lawyer_app/employers/
#http://127.0.0.1:8000/lawyer_app/insurance/
#http://127.0.0.1:8000/lawyer_app/opp_coun/
#http://127.0.0.1:8000/lawyer_app/liens/
